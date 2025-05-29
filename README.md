# Aplicación de Control de Gastos de Coches
Esta aplicación es para gestionar los gastos de mantenimiento de los coches.

## Objetivo
Permitir que distintos usuarios puedan registrar coches, gestionar gastos, y compartir la propiedad de coches con otros usuarios mediante códigos UUID.
El sistema controla el acceso, registra los gastos y permite filtrar los datos por diferentes criterios.

---

### Diseño

`Usuario` (nombre unico, UUID, contraseña)
`Coche` (marca, modelo, matrícula, año)
`Gasto` (tipo, kilometraje, fecha, importe, descripción opcional)
Relación muchos-a-muchos: `Usuario_Coche`