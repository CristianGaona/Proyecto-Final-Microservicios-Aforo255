# Proyecto-Final-Microservicios-Aforo255
## Flujo del proyecto 📄
* El microservicio de invoices, debe listar las facturas de clientes y además debe consumir una cola para cambiar el estado de la factura cuando esta se paga a través del microservicio de pago.
* El microservicio de pago debe registrar el pago en su respectiva bd y además debe dejar un mensaje en una cola para actualizar la factura en el microservicio de facturas y además debe dejar un mensaje en una cola para registrar el movimiento en el microservicio de transacciones.
* El microservicio de transacciones debe listar las transacciones de una factura, además debe consumir una cola para obtener las transacciones de pago del microservicio de pago.
* Todos los microservicios deben consumir la cadena de conexión desde el servicio de configuración centralizada.
## Link Video Presentación 🚀
https://drive.google.com/file/d/1Gp37iLi9UOo6rsSRJBYPkFe03AXjQn5E/view?usp=sharing

## Link Script Base de datos 🛠️
* https://github.com/CristianGaona/Proyecto-Final-Microservicios-Aforo255/tree/master/Script-MySQL8-pay
* https://github.com/CristianGaona/Proyecto-Final-Microservicios-Aforo255/tree/master/Script-Postgres-invoice
## Link archivos configuración centralizada 🔧
* https://github.com/CristianGaona/Config-server-test 
