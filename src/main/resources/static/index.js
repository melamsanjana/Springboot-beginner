var users =[
    {
        image: "/images/john.png",
        name: "John Doe",
        gender: "Male"
    },
    {
        image: "/images/jane.png",
        name: "Jane Doe",
        gender: "Female"
    }
];
var id=0;

function toggleUser() {
    id = (id + 1) % users.length;
    var userImage=document.getElementById("user-image");
    var userName=document.getElementById("user-name");
    var userGender=document.getElementById("user-gender");

    userImage.src=users[id].image;
    userName.textContent=users[id].name;
    userGender.textContent=users[id].gender;

}