function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    const results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

// Get the values from URL parameters
const assetName = getUrlParameter('name');
const leadingPrice = getUrlParameter('price');
const returnFee = getUrlParameter('fee');
const imageUrl = getUrlParameter('image');

// Update the content of the h2, p, and image tags
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('assetName').textContent = assetName;
    document.getElementById('leadingPrice').textContent = `Leading Price: $${leadingPrice}`;
    document.getElementById('returnFee').textContent = `Late Return Fee: $${returnFee} per day`;

    // Set the image source
    const imageElement = document.getElementById('assetImage');
    imageElement.src = imageUrl;
    imageElement.alt = assetName; // Set alt text for the image
});