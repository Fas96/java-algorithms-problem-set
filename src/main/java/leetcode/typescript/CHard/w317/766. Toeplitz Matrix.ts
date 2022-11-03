function isToeplitzMatrix(matrix: number[][]): boolean {
    for (let i = 0; i < matrix.length - 1; i++) {
        for (let j = 0; j < matrix[0].length - 1; j++) {
            if (matrix[i][j] !== matrix[i + 1][j + 1]) {
                return false;
            }
        }
    }
    return true;

};
{
    "isBundle": null,
    "code": "N00000001",
    "endDate": "2022-12-01T00:00:00.000Z",
    "creatorId": "admin",
    "isContainer": true,
    "projYear": "2019",
    "title": "임베디드 음성인식 AI 기능을 탑재한 차량 오버 헤드 콘솔 제어 모듈 개발",
    "noteStatus": null,
    "noteNo": null,
    "dcsource": null,
    "modified": "2022-11-02T02:31:36.434Z",
    "noteKind": null,
    "authPermission": null,
    "fileModified": null,
    "creator": "Administrator",
    "created": "2020-07-03T04:14:46.349Z",
    "projStatus": "open",
    "userName": "user01",
    "sharedDate": null,
    "firstName": "김구",
    "isFolder": false,
    "size": null,
    "nodeRef": "workspace://SpacesStore/ad9799ed-fea3-49ed-a003-3afc75f86d31",
    "fileCreated": null,
    "name": "000000001",
    "isShared": false,
    "startDate": "2019-01-01T00:00:00.000Z"
}