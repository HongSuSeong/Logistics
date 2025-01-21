물류시스템
# Logistics System ERD (WMS, OMS, TMS 기반)
- - -
### OMS (Order Management System)
[Customer] 
[+] customer_id: INT (PK)

name: VARCHAR

email: VARCHAR

phone: VARCHAR



[Order] 
[+] order_id: INT (PK)

order_date: DATE

customer_id: INT (FK)

total_amount: DECIMAL

order_status: VARCHAR



[OrderDetail] 

[+] order_detail_id: INT (PK)

order_id: INT (FK)

product_id: INT (FK)

quantity: INT

price: DECIMAL



[Return] 

[+] return_id: INT (PK)

order_id: INT (FK)

return_date: DATE

reason: TEXT

return_status: VARCHAR


- - -
### WMS (Warehouse Management System)
[Supplier] 

[+] supplier_id: INT (PK)

name: VARCHAR

contact_info: VARCHAR



[Product] 

[+] product_id: INT (PK)

name: VARCHAR

description: TEXT

price: DECIMAL

supplier_id: INT (FK)



[Warehouse] 

[+] warehouse_id: INT (PK)

name: VARCHAR

location: VARCHAR

capacity: INT



[Inventory] 

[+] inventory_id: INT (PK)

warehouse_id: INT (FK)

product_id: INT (FK)

quantity: INT



[Picking] 

[+] picking_id: INT (PK)

order_id: INT (FK)

warehouse_id: INT (FK)

picking_date: DATE



[Packaging] 

[+] packaging_id: INT (PK)

order_id: INT (FK)

packaging_date: DATE

packaging_type: VARCHAR


- - -
### TMS (Transport Management System)
[Shipment] 

[+] shipment_id: INT (PK)

order_id: INT (FK)

warehouse_id: INT (FK)

shipment_date: DATE

shipment_status: VARCHAR



[Delivery] 

[+] delivery_id: INT (PK)

shipment_id: INT (FK)

delivery_date: DATE

delivery_status: VARCHAR

carrier: VARCHAR



[Transport] 

[+] transport_id: INT (PK)

delivery_id: INT (FK)

vehicle_type: VARCHAR

route_info: TEXT

driver_name: VARCHAR



# Relationships
Customer.customer_id < Order.customer_id

Order.order_id < OrderDetail.order_id

OrderDetail.product_id > Product.product_id

Product.supplier_id < Supplier.supplier_id

Product.product_id < Inventory.product_id

Warehouse.warehouse_id < Inventory.warehouse_id

Order.order_id < Shipment.order_id

Shipment.warehouse_id < Warehouse.warehouse_id

Shipment.shipment_id < Delivery.shipment_id

Delivery.delivery_id < Transport.delivery_id

Order.order_id < Return.order_id

Order.order_id < Picking.order_id

Picking.warehouse_id < Warehouse.warehouse_id

Order.order_id < Packaging.order_id
