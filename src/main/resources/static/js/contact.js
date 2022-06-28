// Form input
function getName() {
  var name = document.getElementById("name").value;
  var result = document.getElementById("result");

  if (name.length != 0) {
    return (window.location.href = "./music.html");
  } else {
    return alert("Name must not be empty! You fool!");
  }
}
