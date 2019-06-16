Feature: Mantenimiento de Producto 
  Como jefe de almacen necesito realizar la gestión de Productos

  Scenario: Registrar Producto
    Given   despues de iniciar sesion en la aplicacion
    When 	hago click en el enlace de Mantenimiento de Producto
    And 	luego hago click en el boton de Nuevo
    And 	en campo Nombre el valor de "Galleta Casino Clásica" 
	And 	en campo Cantidad el valor de 20
	And 	en campo Precio Unitario el valor de "0.5"
	And 	en campo Tipo el valor de "Golosinas"
	And 	en campo Nacionalidad el valor de "Peruana"
	And 	en campo Descuento el valor de "unchecked"
	And 	presiono el boton de Guardar
    Then 	el sistema me muestra el mensaje de: "Se guardó correctamente el Producto"
    
  Scenario: Actualizar Producto
    Given   despues de iniciar sesion en la aplicacion
    When 	hago click en el enlace de Mantenimiento de Producto
    And 	busco el producto "Galleta Casino Fresa" para seleccionarlo de la tabla de Producto
    And 	luego hago click en el boton de Editar
    And     en campo Cantidad el valor de 20
    And     en campo Precio Unitario el valor de "0.5"
    And     en campo Tipo el valor de "Golosinas"
    And     en campo Nacionalidad el valor de "Peruana"
    And     en campo Descuento el valor de "unchecked"
    And 	presiono el boton de Actualizar
    Then 	el sistema me muestra el mensaje de: "Se actualizó correctamente el Producto"
    
  Scenario: Eliminar Producto
    Given   despues de iniciar sesion en la aplicacion
    When 	hago click en el enlace de Mantenimiento de Producto
    And 	busco el producto "Galleta Casino Coco" para seleccionarlo de la tabla de Producto
    And     presiono el boton de Eliminar y presiono el boton "Si"
    Then    el sistema me muestra el mensaje de: "Se eliminó correctamente el Producto"

  Scenario: Buscar Producto
    Given   despues de iniciar sesion en la aplicacion
    When 	hago click en el enlace de Mantenimiento de Producto
    And     en la nueva pantalla escribo en campo Filtro el valor de "Galleta Casino Menta"
    And     presiono el boton de Buscar
    Then    el sistema me muestra la lista de productos que corresponden al filtro ingresado
    
  Scenario: Buscar Producto
    Given   despues de iniciar sesion en la aplicacion
    When 	hago click en el enlace de Mantenimiento de Producto
    And     en la nueva pantalla escribo en campo Filtro el valor de ""
    And     presiono el boton de Buscar
    Then    el sistema me muestra la lista de productos que corresponden al filtro ingresado
    
    
  
  