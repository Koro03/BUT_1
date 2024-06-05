
const clicpourvoirplus = (element) => {
    if(element.classList.contains("opened")){
      element.classList.remove("opened")
    }else{
      element.classList.add("opened")
    }
    
  }


function toggleDetails(button) {
  var figure = button.parentNode;
  var details = figure.querySelector('div.hidden');
  details.classList.toggle('initial-hidden');
}


