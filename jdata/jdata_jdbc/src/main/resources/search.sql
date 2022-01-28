SELECT productName
FROM orders
WHERE customer.name = BINARY(:name)
