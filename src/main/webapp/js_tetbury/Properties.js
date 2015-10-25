
/**
 * Lista de propiedades
 * @returns {Conectar}
 */

function LeerProperties()
{

    var pag=window.pagina;
    var tama=window.pagsize;
    //alert(id_presu);
    var url='ServletAjaxForSale.servlet';
    var dataToSend='accion=ListaProperties&pagina='+pag +'&size='+tama;
    var conn = new Conectar(url, dataToSend);
       
    conn.pageRequest.onreadystatechange = function() { ListaProperties(conn.pageRequest); };

    conn.Enviar();
    
    return conn;
}

/**
 * 
 * @param {type} pageRequest
 * @returns {unresolved}
 */
function ListaProperties(pageRequest) {


    if (pageRequest.readyState === 4)
    {
        if (pageRequest.status === 200)
        {
            // Solo descomentar para depuración
            //alert(pageRequest.responseText);
            if (pageRequest.responseText === 'Error')
                alert(pageRequest.responseText);
            else
            {
                CrearTablaProperties(pageRequest.responseText);
                //return pageRequest.responseText;

            }


        }
    }
    else
        return;
}

/**
 * 
 * @param {type} myJson
 * @returns {undefined}
 */
function CrearTablaProperties(myJson)
{

    var tabla = new grid("oTabla");
    var j = 0;
    var myfila=window.fila;

    var obj = JSON.parse(myJson);

    // borrar las tuplas de consultas anteriores
    deleteLastRow("oTabla");
    
    //alert(myJson);
    
    for (j = 0; j <= (obj.length - 1); j++)
    {
        //alert(obj[j].Descripcion);
        var row = tabla.AddRowTable(j + 1);

        //tabla.AddRowCellText(row, 0, obj[j].id);
        var celda = tabla.AddRowCellText(row, 0, obj[j].id);
        celda.setAttribute('hidden', 'true'); // ocultar la columna ID
        tabla.AddRowCellText(row, 1, obj[j].tipo_vivienda );
        tabla.AddRowCellText(row, 2, obj[j].num_bedrooms );
        tabla.AddRowCellText(row, 3, obj[j].garage );
        
        tabla.AddRowCellNumber(row, 4, obj[j].LocalePrice );
        
        tabla.AddRowCellText(row, 5, obj[j].zona );
        tabla.AddRowCellText(row, 6, obj[j].urbanization );
    
        window.fila++;
        myfila=window.fila;
    }
    obj=null;


}
