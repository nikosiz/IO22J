var i = 0;
function move() {
    if (i === 0) {
        i = 1;
        var elem = document.getElementById("myBar");
        var width = 1;
        // ono niby wykorzystuje ilość pól i jest wolniej jak ich jest więcej ale zrobione bardzo na oko
        var id = setInterval(frame, fieldCount * 250);
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