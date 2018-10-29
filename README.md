# jwt-validation

1. to decode header.payload.signature;
2. validate the signature;
3. validate the payload claims;
4. invalid token handlers;

expose some city data via a REST API:
http://localhost/RESTService/api/city

Respond either as json or xml depending on the request header:
[{
"id":1,
"cityName":"Munich",
"countryCode":"DE",
"postCode":"81927"
}]


grails 2.4.4 depends on spring-core-4.0.7

spring-security-oauth2 and spring-security-jwt

example project is referring to
https://jolorenz.wordpress.com/2014/02/28/create-a-restservice-api-with-grails-2-3-x-in-15-minutes/
