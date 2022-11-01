 import {AlfrescoRestApi} from "./AlfrescoRestApi";

    describe('AlfrescoRestApi tests', () => {
        it('should get alfresco content', async () => {
            let alfrescoRestApi = AlfrescoRestApi.getAlfrescoRestApi();
            let result = await alfrescoRestApi.getContentForSite('elnfreespace');
            console.log(result);
        });
    })

 describe('AlfrescoRestApi tests', () => {
        jest.setTimeout(20000*20000);
        it('should upload file', async () => {
            let alfrescoRestApi = AlfrescoRestApi.getAlfrescoRestApi();
            let result = await alfrescoRestApi.uploadFileIntoGivenFolderDirectory('elnworkingspace',  '/Users/fasbhim/Documents/2022/fas/algorithms/java-algorithms/src/main/java/leetcode/typescript/CHard/jest.md', '/000000001/shared_files/', 'user01');
            console.log(result);
        });
    });

    describe('AlfrescoRestApi tests', () => {
        jest.setTimeout(20000*20000);
        it('should upload file', async () => {
            let alfrescoRestApi = AlfrescoRestApi.getAlfrescoRestApi();
            let result = await alfrescoRestApi.getNodeContent('000000001');
            console.log(result);
        });
    })





