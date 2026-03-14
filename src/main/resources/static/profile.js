const userId = 1;

let profileData = {};

window.onload = loadProfile;

function loadProfile(){

    fetch(`/api/users/profile/${userId}`)
        .then(res=>res.json())
        .then(data=>{

            profileData = data;

            document.getElementById("username").innerText = data.name;
            document.getElementById("nameText").innerText = data.name;
            document.getElementById("bioText").innerText = data.bio;
            document.getElementById("avatarPreview").src = data.avatarUrl;

        });
}

function editField(field){

    let value = prompt("Enter new value:");

    if(value){
        profileData[field] = value;

        if(field==="name")
            document.getElementById("nameText").innerText=value;

        if(field==="bio")
            document.getElementById("bioText").innerText=value;

        if(field==="avatarUrl")
            document.getElementById("avatarPreview").src=value;
    }
}

function saveProfile(){

    fetch(`/api/users/profile/${userId}`,{

        method:"PUT",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify(profileData)

    })
        .then(()=>alert("Profile updated"));

}