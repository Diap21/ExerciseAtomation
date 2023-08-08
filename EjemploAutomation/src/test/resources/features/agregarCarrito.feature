# language: es

Característica: Realizar compras de artículos
  Como un nuevo cliente
  Quiero ingresar a la página www.abc.com
  Para realizar una compra de un artículo

  Escenario: Agregar artículos al carrito de compras
    Dado que un nuevo cliente accede hasta la web de compras
    Cuando el agrega 1 producto de Bicicletas al carro
    Entonces el ve los productos listados en el carro de compras

  Esquema del escenario: Agregar artículos al carrito de compras
    Dado que un nuevo cliente accede hasta la web de compras
    Y agrego productos al carro
    Y ha realizado checkout
    Cuando agrega su información personal
      | FirstName | LastName | PostalCode |
      | oscar     | lopez    | 130113     |
    Y realiza la orden del pedido con botón continuar
    Y la orden de compra puede visualizarse
    Y finaliza el procedimiento
    Entonces puede visualizarse el resultado exitoso de la compra