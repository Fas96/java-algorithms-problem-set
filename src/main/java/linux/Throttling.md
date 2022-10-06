## What is API Gateway Throttling

<strong>API Gateway throttling </strong>is a mechanism to control the <strong>number of requests</strong> that can be made to an <strong>API</strong>. This is useful to control the <strong>load on the backend service</strong> and to prevent abuse of the API. 
Throttling can be <strong>applied</strong> at the <strong>API level</strong>, <strong>resource level</strong>, or <strong>method level</strong>. Throttling can be applied to <strong>both the requests that are made to the API and the responses that are returned from the API</strong>.

![](https://apim.docs.wso2.com/en/3.2.0/assets/img/learn/throttling-types.png)


## API Gateway Throttling Types

There are two types of throttling in API Gateway: <strong>Request Throttling</strong> and <strong>Response Throttling</strong>.
![](https://d0.awsstatic.com/products/APIGateway/RequestProcessingWorkflow.jpg)

### Request Throttling

<strong>Request throttling</strong> is the process of limiting the number of requests that can be made to an API. This is useful to control the load on the backend service and to prevent abuse of the API.

### Response Throttling

<strong>Response throttling</strong> is the process of limiting the number of responses that can be returned from an API. This is useful to control the load on the backend service and to prevent abuse of the API.

## API Gateway Throttling Scenarios

There are two types of throttling scenarios in API Gateway: <strong>Global Throttling</strong> and <strong>Advanced Throttling</strong>.

### Global Throttling

<strong>Global throttling</strong> is the process of limiting the number of requests that can be made to an API. This is useful to control the load on the backend service and to prevent abuse of the API.

### Advanced Throttling

<strong>Advanced throttling</strong> is the process of limiting the number of requests that can be made to an API based on a specific condition. This is useful to control the load on the backend service and to prevent abuse of the API.

## API Gateway Throttling Policies

There are two types of throttling policies in API Gateway: <strong>Request Count Throttling</strong> and <strong>Bandwidth Throttling</strong>.

### Request Count Throttling

<strong>Request count throttling</strong> is the process of limiting the number of requests that can be made to an API. This is useful to control the load on the backend service and to prevent abuse of the API.

### Bandwidth Throttling

<strong>Bandwidth throttling</strong> is the process of limiting the number of responses that can be returned from an API. This is useful to control the load on the backend service and to prevent abuse of the API.



### How does API Gateway Throttling work?

1. The API Gateway receives a request from the client.
2. The API Gateway checks whether the request is throttled or not.
3. If the request is throttled, the API Gateway returns a 429 response to the client.
4. If the request is not throttled, the API Gateway forwards the request to the backend service.
5. The backend service returns a response to the API Gateway.
6. The API Gateway checks whether the response is throttled or not.
7. If the response is throttled, the API Gateway returns a 429 response to the client.
8. If the response is not throttled, the API Gateway returns the response to the client.
9. The client receives the response from the API Gateway. 

### How do you use API Gateway Throttling in Spring Boot?
 ... to be continued  ![](https://i.stack.imgur.com/hzk6C.gif)


## Reference
[amazon](https://aws.amazon.com/ko/blogs/architecture/throttling-a-tiered-multi-tenant-rest-api-at-scale-using-api-gateway-part-1/) <br>
[apim docs](https://apim.docs.wso2.com/en/3.2.0/learn/rate-limiting/introducing-throttling-use-cases/)
[tibco](https://www.tibco.com/reference-center/what-is-api-throttling)
