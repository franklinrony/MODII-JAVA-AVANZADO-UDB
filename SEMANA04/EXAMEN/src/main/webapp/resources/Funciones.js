$(function() {
$(".modalDisplay").click(function() {
var mod = $(this).attr('data-target');
$("#" + mod).modal("show");
});
$(".closeDlg").click(function() {
$(".modal").modal("hide");
});
$(".editar").click(
function() {
var cod = $(this).attr('data-target');
$.getJSON('/Bilioteca_UDB/formularioEditarLibro',
"codigo=" + cod,
function(data) {
$('.mdNuevo').modal("show");
$("#cod").val(data["idBook"]);
$("#title").val(data["title"]);
$("#autor").val(data["author"]);
$("#genero").val(data["genre"]);
$("#stock").val(data["stock"]);
$("#tituloGuardar").text("Modificar Libro");
$("#cod").attr('readonly', true);
}
)
}
);

$('#nuevoLibro').click(function() {
$('.mdNuevo').modal("show");
$("#cod").val("");
$("#titulo").val("");
$("#autor").val("");
$("#genero").val("");
$("#stock").val("");
$("#tituloGuardar").text("Nuevo Libro");
$("#cod").attr('disabled', false);
});
$('#MnEstudiante').click(function() {
$('.estudiante').show();
});


$(".sltDocente").on('change',
function() {
var idDocente = $(this).val();
$.ajax({
contentType: "application/json",
url: "/Bilioteca_UDB/listaCursosByNombre?idDocente=" + idDocente,
dataType: 'json',
timeout: 100000,
success: function(data) {
$('#curso').find("option").remove();
$('#curso').append(`<option value="0">
Seleccione
</option>`);
console.log("SUCCESS: ", data);
data.forEach(function(item) {
$('#curso').append(`<option value="${item.idcurso}">
${item.curso}
</option>`);
});
},
error: function(e) {
console.log("ERROR: ", e);
},
done: function(e) {
console.log("DONE");
}
});
}
);
})
