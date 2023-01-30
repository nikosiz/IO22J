var i = 0;
function move() {
    if (i === 0) {
        i = 1;
        var elem = document.getElementById("myBar");
        var width = 1;

        const manualForm = document.getElementById('manual-form');
        const importForm = document.getElementById('import-form');

        var id;
        if (manualForm.elements['search-main'].value.length > 0) {
            id = setInterval(frame, fieldCount * 300);
        } else if (importForm.elements['file'].value.length > 0) {
            id = setInterval(frame, 1000);
        }
        function frame() {
            if (width >= 100) {
                clearInterval(id);
                i = 0;
            } else {
                width++;
                elem.style.width = width + "%";
            }
        }
    }
}