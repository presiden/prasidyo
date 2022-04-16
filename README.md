# Soal Test Code REST API
# List URL
1. Fibonacci : http://localhost:8080/api/get-fibonacci/{input}
2. Menghitung irisan string : http://localhost:8080/api/count-irisan-string/{input}
3. Menampilkan object : http://localhost:8080/api/product/{id}
4. Menampilkan list of object : http://localhost:8080/api/product-list


### Skrip untuk view export csv
create or replace view transaction_report_view as
select
	ROW_NUMBER () OVER (ORDER BY date_trunc('day', o.created_date)) id, 
	date_trunc('day', o.created_date)::date as created_date,
	c."name" as company_name,
	p."name" as product_name,
	sum(od.quantity) quantity,
	od.price,
	sum(od.total_price) total_price,
	p.stock
from orders o
join order_details od 
on od.order_id = o.id
join company c
on c.id = o.company_id
join product p 
on p.id = od.product_id
group by date_trunc('day', o.created_date), c.id, p.id, p.stock, od.price;
