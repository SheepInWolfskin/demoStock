# stock record system

this project was set to run with Docker. Simply run a docker when running the system to demo the outcome.

# Example Usage of EndPoints
getStock GET `localhost:8080/api/v1/stock/getStock?code=AA`

addStock POST `localhost:8080/api/v1/stock/addStock`
with example JSON 
```
{
"code": "AA",
"date": "1/7/2011",
"quarter": "4"
}
```

uploadFile POST `localhost:8080/api/v1/stock/uploadFile`
with data file

updateStock PUT `localhost:8080/api/v1/stock/updateStock`
with example JSON
```
{
    "code": "AA",
    "date": "1/7/2011",
    "quarter": "4"
}
```