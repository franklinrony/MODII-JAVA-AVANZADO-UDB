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
$.getJSON('/SpringMVC004/formularioEditarEstudiante',
"codigo=" + cod,
function(data) {
$('.mdNuevo').modal("show");
$("#cod").val(data["codigo"]);
$("#nombre").val(data["nombre"]);
$("#apellido").val(data["apellido"]);
$("#cum").val(data["cum"]);
$("#cuotaMensual").val(data["cuotaMensual"]);
$("#tituloGuardar").text("Modificar Estudiante");
$("#cod").attr('readonly', true);
}
)
}
);
$('#nuevoEstudiante').click(function() {
$('.mdNuevo').modal("show");
$("#cod").val("");
$("#nombre").val("");
$("#apellido").val("");
$("#cum").val("");
$("#cuotaMensual").val("");
$("#tituloGuardar").text("Nuevo Estudiante");
$("#cod").attr('disabled', false);
});
$('#MnEstudiante').click(function() {
$('.estudiante').show();
});
})
