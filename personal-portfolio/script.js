let menu = document.querySelector("#menu-icon");
let navlist = document.querySelector(".navlist");

menu.addEventListener("click", function(){
    menu.classList.toggle("active");
    navlist.classList.toggle("active");
});

window.onscroll = () => {
    menu.classList.remove("active");
    navlist.classList.remove("active");
};

console.log("hello world");