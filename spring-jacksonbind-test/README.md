# Jackson bind Test

## ๐ ์ฝํ๋ฆฐ Jackson Bind


### ๊ธฐ๋ณธ ์์ฑ์ ์์ผ๋ฉด binding ์คํจ
```kotlin
data class MemberRequestKtDto1(
    var id: Long = 0L,
    var name: String,
    var address: String,
    var email: String
)
```
- ์ด๋ ๊ฒ ์ฃผ์์ฑ์ ์ธ์ ์ค default value ์ง์ ๋์ง ์๋ ๊ฒ์ด ํ๋๋ผ๋ ์์ผ๋ฉด **๊ธฐ๋ณธ ์์ฑ์ ์์ฑ X**
- ์ด๋ฐ ๊ฒฝ์ฐ ์์ `ObjectMapper`๋ฅผ ์ด์ฉํด binding ํ๋ค๋ฉด ์๋ฌ ๋ฐ์

```groovy
implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
```
```kotlin
mapper = jacksonObjectMapper()
mapper = ObjectMapper().registerKotlinModule()
mapper = ObjectMapper().registerModule(KotlinModule()) // deprecated
```
- `jackson-module-kotlin` ๋ชจ๋์ `ObjectMapper`์ ๋ฑ๋กํ๋ฉด data class์ ๋ํด์ ๊ธฐ๋ณธ์์ฑ์๋ฅผ ์์ฑํด์ค

### ์ฃผ์์ฑ์ private ์ธ์
- `jackson-module-kotlin` ๋ชจ๋์ด ์ฃผ์์ฑ์ private ์ธ์์ ๋ํด์๋ binding ํด์ค
  - ๊ฐ ํ๋๋ง๋ค `@field:JsonProperty(...)`๋ฅผ ์ง์ ํด์ค ๊ฒ๊ณผ ๋น์ท

### ์คํ๋ง ๋ถํธ MVC์์์ binding
- `HttpMessageConverter`์์ ์ฌ์ฉ๋๋ Jackson ๊ด๋ จ `ObjectMapper`์๋ `KotlinModule`์ด ๋ฐ๋ก ๋ฑ๋ก๋์ด ์์ง๋ ์์
- data class์ ๊ธฐ๋ณธ์์ฑ์๊ฐ ์์ด๋ ์คํ๋ง ๋ถํธ๋ ๊ธฐ๋ณธ์ ์ผ๋ก `ParameterNamesModule`๋ฅผ ํฌํจํ๊ณ  ์๊ธฐ ๋๋ฌธ์ converting ์ ์ด๋ฃจ์ด์ง
- KotlinModule์ ๋ฑ๋ก๋์ด ์์ง ์์์ ์ฃผ์์ฑ์ ์ธ์ ์ค์ private ์ ๊ทผ์๊ฐ ๋ถ์ด ์๋ ํ๋์ ๋ํด์๋ binding์ด ์๋๋ค.
  - request body์์ json ๋ฐ์ดํฐ ์ค private ์ ๊ทผ์ ์ธ์์ ๋งคํ๋๋ ๊ฒฝ์ฐ binding ์คํจ -> ์๋ฌ ๋ฐ์