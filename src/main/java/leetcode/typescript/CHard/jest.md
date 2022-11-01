## What is Jest and How to use it in testing?
<b>Jest</b> is a <b>JavaScript testing framework</b> maintained <b>by Facebook, Inc</b>. Jest is well <b>known for its speed</b>, <b>reliability</b>, and <b>ease of use.</b> 
It works out of the box for most <b>JavaScript projects.</b> Jest is a complete and ready to set-up <b>JavaScript testing solution</b>. It lets you write tests with an <b>approachable, familiar and feature-rich API </b>that gives you results quickly. Jest is well-documented, requires little configuration and can be extended to match your requirements.

### How to use Jest in testing?

#### Pre-requisites
```bash
- Node.js
- npm
- Jest
```



In this example lets see how we can use jest in testing our typescript code. So we need to install jest and typescript.
```bash
npm install --save-dev jest
```
```bash
npm i -D jest typescript
```


#### package.json
Our package.json file should look like this for our dependencies.

```json
{
  "name": "fas-typeScripting",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "directories": {
    "doc": "doc"
  },
  "scripts": {
    "test": "jest"
  },
  "repository": {
    "type": "git"
  },
  "keywords": [],
  "author": "Fas",
  "license": "ISC",
  "dependencies": {
    "@types/jest": "^29.1.2",
    "@types/node": "^16.11.6",
    "jest": "^29.0.0",
    "ts-jest":  "^29.0.0",
    "typescript": "^4.5.2"
  },
  "devDependencies": {
    "jest": "^29.0.3",
    "jest-environment-jsdom": "^29.0.3",
    "typescript": "^4.8.3"
  }

}
```
### Jest Configuration
Jest configuration is done in the package.json file. We can also create a separate configuration file for jest. In this example we will be using the<b> jest.config.js </b>file for jest configuration.
```javascript
module.exports = {
    preset: "ts-jest",
    testEnvironment: "node"
};
```
or use the command <b>npx ts-jest config:init </b> to create a <b>jest.config.js file.</b>

#### Write a test
[regular-expression-matching (Leetcode-H)](https://leetcode.com/problems/regular-expression-matching/)
our code in separate file(regular-expression-matching.ts) and import it in our test file.
```javascript
export default  function isMatch(s: string, p: string): boolean {
    count:Number;
    tem:String;
    if(p.length==0){
        return s.length==0;
    }
    if(p.length==1){
        return s.length==1&&(p[0]==s[0]||p[0]=='.');
    }
    if(p[1]!='*'){
        if(s.length==0){
            return false;
        }
        return (p[0]==s[0]||p[0]=='.')&&isMatch(s.substring(1),p.substring(1));
    }
    while(s.length>0&&(p[0]==s[0]||p[0]=='.')){
        if(isMatch(s,p.substring(2))){
            return true;
        }
        s=s.substring(1);
    }
    return isMatch(s,p.substring(2));
}
```

### The test file
The test file should be in the same directory as the code file. The test file should have the same name as the code file with the <b>.test extension</b>. In this example we will be using the <b>regular-expression-matching.test.ts</b> file for testing our code.
```javascript
import isMatch from './c10RegularExpressionMatching'

describe('isMatch', () => {
    it('isMatch', () => {
        expect(isMatch("aa","a")).toEqual(false);
        expect(isMatch("aa","a*")).toEqual(true);
        expect(isMatch("ab",".*")).toEqual(true);
        expect(isMatch("aab","c*a*b")).toEqual(true);
        expect(isMatch("mississippi","mis*is*p*.")).toEqual(false);
    });
});
```
### Common Bash Commands in testing

####  Run your tests
```bash
npm test
```
####  Coverage reports
```bash
npm test -- --coverage
```
#### Continuous Integration
```bash
npm test -- --ci --coverage
```
####  Update snapshots
```bash
npm test -- -u
```
####  Run tests from one file
```bash
npm test -- FileName
```
####  Run tests with a test name pattern
```bash
npm test -- -t 'pattern'
```
####  Run tests in band
```bash
npm test -- --runInBand
```
####  Run tests in a specific environment
```bash
npm test -- --env=jsdom
```
#### Run tests with a specific config
```bash
npm test -- --config=customConfig.json
```
####  Run tests with a specific global setup file
```bash
npm test -- --globalSetup=customSetup.js
```
####   Run tests with a specific global teardown file
```bash
npm test -- --globalTeardown=customTeardown.js
```
####   Run tests with a specific reporter
```bash
npm test -- --reporters=default
```
####  Run tests with a specific test results processor
```bash
npm test -- --testResultsProcessor=customProcessor.js
```
####  Run tests with a specific test sequencer
```bash
npm test -- --testSequencer=customSequencer.js
```
####  Run tests with a specific watch plugins
```bash
npm test -- --watchPlugins=customPlugin.js
```

### Common jest functions
####  afterAll(fn, timeout)
How the <b>afterAll function works </b>is that it runs after all the tests in the file have been executed. It is used to <b>clean up the resources</b> that were used in the tests. It is also <b>used to close the database connection or to close the server connection.</b>
```javascript
afterAll(() => {
    console.log('afterAll');
});
```
####  afterEach(fn, timeout)
The <b>afterEach function</b> is used to <b>clean up the resources</b> that were used in the tests. It is also <b>used to close the database connection or to close the server connection.</b>
```javascript
afterEach(() => {
  console.log('afterEach');
});
```
####  beforeAll(fn, timeout)
The <b>beforeAll function</b> is used to <b>initialize the resources</b> that will be used in the tests. It is also <b>used to open the database connection or to open the server connection.</b>
```javascript
beforeAll(() => {
  console.log('beforeAll');
});
```
####  beforeEach(fn, timeout)
The <b>beforeEach function</b> is used to <b>initialize the resources</b> that will be used in the tests. It is also <b>used to open the database connection or to open the server connection.</b>
```javascript
beforeEach(() => {
  console.log('beforeEach');
});
```
####  describe(name, fn)
The <b>describe function</b> is used to group the tests. It is used to group the tests that are related to each other. It is also used to group the tests that are related to a specific feature.
```javascript
describe('outer', () => {
  console.log('describe outer-a');

  describe('describe inner 1', () => {
    console.log('describe inner 1');
  });

  console.log('describe outer-b');

  describe('describe inner 2', () => {
    console.log('describe inner 2');
  });

  console.log('describe outer-c');
});
```
####  test(name, fn, timeout)
The <b>test function</b> is used to write the test cases. It is used to write the test cases for the code that we have written.
```javascript
test('this will be used as the description', () => {
  expect(true).toBe(true);
});
```
####  test.only(name, fn, timeout)
The <b>test.only function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test function</b> and the <b>test.only function</b> is that the <b>test function</b> will run all the test cases in the file while the <b>test.only function</b> will run only the test cases that are written using the <b>test.only function</b>.
```javascript
test.only('this will be the only test that runs', () => {
  expect(true).toBe(false);
});

test('this test will not run', () => {
  expect('A').toBe('A');
});
```
####  test.skip(name, fn, timeout)
The <b>test.skip function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test function</b> and the <b>test.skip function</b> is that the <b>test function</b> will run all the test cases in the file while the <b>test.skip function</b> will skip the test cases that are written using the <b>test.skip function</b>.
```javascript
test.skip('this test will not be run', () => {
  expect('A').toBe('A');
});
```
####  test.concurrent(name, fn, timeout)
The <b>test.concurrent function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test function</b> and the <b>test.concurrent function</b> is that the <b>test function</b> will run the test cases in the file sequentially while the <b>test.concurrent function</b> will run the test cases in the file concurrently.
```javascript
test.concurrent('this test runs concurrently with others', () => {
  expect(true).toBe(true);
});
```
####  test.concurrent.only(name, fn, timeout)
The <b>test.concurrent.only function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test.concurrent function</b> and the <b>test.concurrent.only function</b> is that the <b>test.concurrent function</b> will run the test cases in the file concurrently while the <b>test.concurrent.only function</b> will run only the test cases that are written using the <b>test.concurrent.only function</b>.
```javascript
test.concurrent.only('this test runs concurrently with others', () => {
  expect(true).toBe(true);
});
```
####  test.concurrent.skip(name, fn, timeout)
The <b>test.concurrent.skip function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test.concurrent function</b> and the <b>test.concurrent.skip function</b> is that the <b>test.concurrent function</b> will run the test cases in the file concurrently while the <b>test.concurrent.skip function</b> will skip the test cases that are written using the <b>test.concurrent.skip function</b>.
```javascript
test.concurrent.skip('this test runs concurrently with others', () => {
  expect(true).toBe(true);
});
```
####  test.each(table)(name, fn, timeout)
The <b>test.each function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test function</b> and the <b>test.each function</b> is that the <b>test function</b> will run the test cases in the file sequentially while the <b>test.each function</b> will run the test cases in the file concurrently.
```javascript
test.each([
  [1, 1, 2],
  [1, 2, 3],
  [2, 1, 3],
])('.add(%i, %i)', (a, b, expected) => {
  expect(a + b).toBe(expected);
});
```
####  test.each(table).only(name, fn, timeout)
The <b>test.each.only function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test.each function</b> and the <b>test.each.only function</b> is that the <b>test.each function</b> will run the test cases in the file concurrently while the <b>test.each.only function</b> will run only the test cases that are written using the <b>test.each.only function</b>.
```javascript
test.each([
  [1, 1, 2],
  [1, 2, 3],
  [2, 1, 3],
]).only('.add(%i, %i)', (a, b, expected) => {
  expect(a + b).toBe(expected);
});
```
####  test.each(table).skip(name, fn, timeout)
The <b>test.each.skip function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test.each function</b> and the <b>test.each.skip function</b> is that the <b>test.each function</b> will run the test cases in the file concurrently while the <b>test.each.skip function</b> will skip the test cases that are written using the <b>test.each.skip function</b>.
```javascript
test.each([
  [1, 1, 2],
  [1, 2, 3],
  [2, 1, 3],
]).skip('.add(%i, %i)', (a, b, expected) => {
  expect(a + b).toBe(expected);
});
```
####  test.todo
The <b>test.todo function</b> is used to write the test cases. It is used to write the test cases for the code that we have written. The difference between the <b>test function</b> and the <b>test.todo function</b> is that the <b>test function</b> will run the test cases in the file sequentially while the <b>test.todo function</b> will run the test cases in the file concurrently.
```javascript
test.todo('this test is a todo');
```


## Reference
- [Jest](https://jestjs.io/)
- [Jest Documentation](https://jestjs.io/docs/en/getting-started)
- [Jest API](https://jestjs.io/docs/en/api)
- [Jest CLI Options](https://jestjs.io/docs/en/cli)
- [Jest Configuration](https://jestjs.io/docs/en/configuration)
- [Jest Expect](https://jestjs.io/docs/en/expect)
- [Jest Mock Functions](https://jestjs.io/docs/en/mock-functions)
- [Jest Mocking Modules](https://jestjs.io/docs/en/mock-functions#mocking-modules)
- [Jest Snapshot Testing](https://jestjs.io/docs/en/snapshot-testing)