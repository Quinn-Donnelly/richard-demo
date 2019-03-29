console.log("this is the manager script");
const BASE_URL = "http://localhost:8080/website";


const request = new XMLHttpRequest();
request.onreadystatechange = () => {
  if (request.readyState === 4 && request.status >= 200 && request.status < 300) {
    const json = JSON.parse(request.responseText);
    console.log(json);

    const textNode = document.createTextNode(json.msg);
    const panel = document.getElementById("msg");
    panel.innerText = json.msg;
  }
}
request.open("POST", `${BASE_URL}/hello`);

const data = {
  "msg": "quinn"
}

request.send(JSON.stringify(data));