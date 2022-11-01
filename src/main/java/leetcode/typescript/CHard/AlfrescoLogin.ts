export function AlfrescoLogin() {
    const HOST = 'http://localhost:8080';
    var alfresco = require('alfresco-js-api');
     let alfrescoJsApi = new alfresco({
        hostEcm: HOST
    });

    const userId = 'admin';
    const pswd = 'admin';
    let ticket = null;
    alfrescoJsApi.alfrescoJsApi.login(userId, pswd).then(function(data) {
        ticket = data; console.log(ticket);
        var isLoggedIn = alfrescoJsApi.isLoggedIn();
        console.log('Status=', isLoggedIn);
        alfrescoJsApi.logout()
            .then(
                function (data) { console.log('Successfully Logout'); },
                function (error) { console.error('Possible ticket already expired');});
    });
}