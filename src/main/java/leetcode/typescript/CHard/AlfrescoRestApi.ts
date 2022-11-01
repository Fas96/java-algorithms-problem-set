import * as Http from "http";


export  class AlfrescoRestApi {
    public static getAlfrescoRestApi(): AlfrescoRestApi {
        return new AlfrescoRestApi();
    }

    getContentForSite(siteType: string): Promise<any> {
        return new Promise((resolve, reject) => {
            const options = {
                host: 'researchworks.argonet.co.kr',
                port: 8080,
                path: `/alfresco/s/r2eln/doclib2/treenode/site/${siteType}/documentLibrary?sortAsc=true&sortField=cm:title&noCache=1666137259037`,
                method: 'GET',
                auth: 'admin:elnadmin'
            };
            const req = Http.request(options, (res) => {
                res.setEncoding('utf8');
                res.on('data', (chunk) => {
                    resolve(chunk);
                });
            });
            req.on('error', (e) => {
                reject(e);
            });
            req.end();
        });

    }


    uploadFileIntoGivenFolderDirectory(siteId: string, uploadFile: string, uploaddirectory: string, username: string): Promise<any> {
        return new Promise((resolve, reject) => {
            const params = [
                {"name": "filename", "value": uploadFile},
                {"name": "uploaddirectory", "value": uploaddirectory},
                {"name": "siteId", "value": siteId},
                {"name": "containerId", "value": "documentLibrary"},
                {"name": "username", "value": username}
            ];
            const options = {
                host: 'researchworks.argonet.co.kr',
                port: 8080,
                path: `/share/proxy/alfresco/api/upload?Alfresco-CSRFToken=1coVYXOrsFlGHMYZgNJZj7rwbF%2FlOpnQTgHZqwDBQXw%3D`,
                method: 'POST',
                auth: 'admin:elnadmin',
                params: params
            }

            const req = Http.request(options, (res) => {
                res.setEncoding('utf8');
                res.on('data', (chunk) => {
                    resolve(chunk);
                });

            });
            req.on('error', (e) => {
                    reject(e);
                }
            );


        });
    }
//
//     import { AlfrescoApi, NodesApi} from '@alfresco/js-api';
//
// const alfrescoApi = new AlfrescoApi({
//     hostEcm: 'http://127.0.0.1:8080'
// });
//
// const nodesApi = new NodesApi(alfrescoApi);
//
// const opts = {
//     'attachment': true /*  | **true** enables a web browser to download the file as an attachment.
// **false** means a web browser may preview the file in a new tab or window, but not
// download the file.
//
// You can only set this parameter to **false** if the content type of the file is in the supported list;
// for example, certain image files and PDF files.
//
// If the content type is not supported for preview, then a value of **false**  is ignored, and
// the attachment will be returned in the response.
//  */
//     'ifModifiedSince': 2013-10-20T19:20:30+01:00 /*  | Only returns the content if it has been modified since the date provided.
// Use the date format defined by HTTP. For example, Wed, 09 Mar 2016 16:56:34 GMT.
//  */
// 'range': range_example /*  | The Range header indicates the part of a document that the server should return.
// Single part request supported, for example: bytes=1-10.
//  */
// };
//
// nodesApi.getNodeContent(nodeIdopts).then((data) => {
//     console.log('API called successfully. Returned data: ' + data);
// }, function(error) {
//     console.error(error);
// });

    getNodeContent(nodeId: string): Promise<any> {
        return new Promise((resolve, reject) => {
            const options = {
                host: 'researchworks.argonet.co.kr',
                port: 8080,
                path: `/alfresco/s/r2eln/doclib2/node/workspace/SpacesStore/${nodeId}/content?attachment=true`,
                method: 'GET',
                auth: 'admin:elnadmin'
            };
            const req = Http.request(options, (res) => {
                res.setEncoding('utf8');
                res.on('data', (chunk) => {
                    resolve(chunk);
                });
            });
            req.on('error', (e) => {
                reject(e);
            });
            req.end();
        });
    }
}