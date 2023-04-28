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

$('#searchBox').autocomplete({
serviceUrl: '/SpringMVC005_AJAX/listaEstudiantesByNombre',
paramName: "term",
delimiter: ",",
transformResult: function(response) {
return {
suggestions: $.map($.parseJSON(response), function(item) {
return {
value: item.nombre + " " + item.apellido,
data: item.codigo
};
})
};
}
});

$(".sltDocente").on('change',
function() {
var idDocente = $(this).val();
$.ajax({
contentType: "application/json",
url: "/SpringMVC005_AJAX/listaCursosByNombre?idDocente=" + idDocente,
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
