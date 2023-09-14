var counter = 1;
setInterval(function (){
    document.getElementById('radio'+counter).children = true;
    counter++;
    if(counter>3){
        counter = 1;
    }
}, 5000)

function loadAssetPage(assetName, leadingPeriod, returnFee, imageUrl){
        // Create a URL with parameters and navigate to assetRequest.html
    const url =
        `assetRequest.html?name=${encodeURIComponent(assetName)}&price=${encodeURIComponent(leadingPeriod)}&fee=${encodeURIComponent(returnFee)}&image=${encodeURIComponent(imageUrl)}`;
    window.location.href = url;


}