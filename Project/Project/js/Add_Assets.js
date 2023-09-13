function addAssets(){
    window.addEventListener('load',function (){
        //alert("Ready to move on");
        window.addEventListener('submit',function (){
            //alert("Form submitted");
            var firstName=document.
            querySelector("#Name").value;
            var category=document.
            querySelector("#category").value;
            var description=document.
            querySelector("#description").value;
    
            //convert this into json
            var asset={
                "Name":firstName,
                "Category":category,
                "Description":description,
            }
            console.log(JSON.stringify(asset));
            window.localStorage.setItem("EmployeeAsset",JSON.stringify(asset));
    
        })
    })
}