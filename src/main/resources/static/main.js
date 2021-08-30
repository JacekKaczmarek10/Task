$('.table #applyButton').on('click',function(event) {
    console.log("GOOD1")
    event.preventDefault();
    var href = document.getElementById("applyButton").href;
    console.log("GOOD1")
    $('#applyModal #applyRef').attr('href',href);
    $('#applyModal').modal();
    console.log("GOOD1")
});