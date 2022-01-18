function loadHtml(id, fileName){
    console.log(`div id: ${id}, fileName: ${fileName}`);
    let xhttp;
    let element = document.getElementById(id);
    let file = fileName;

    if(file){
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function(){
            if(this.readyState == 4){
                if(this.readyState == 200){
                    element.innerHTML = this.responseText;
                }
            }
        }
        xhttp.open("GET", 'templates/${file}', true);
        xhttp.send();
        return;
    }
}