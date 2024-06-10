const axios = require("axios");
const cheerio = require("cheerio");

const getHtml = async () => {

    return await axios.get("https://roadbook.co.kr/category/%EC%8B%A0%EA%B0%84%EC%86%8C%EA%B0%9C");

}

console.log(getHtml())

getHtml().then(
    (html) => {
        let ulList = [];

        const $ = cheerio.load(html.data);
        const $bodyList = $("div#searchList ol").children("li");

        $bodyList.each((i, elem) => {
            ulList[i] = {
                bookList : $(this).find('a').text(),
                url : $(this).find('a').attr('href')
            }
        })

        return ulList.filter((n) => n.bookList);
    }
).then((result)=>{console.log(result)})