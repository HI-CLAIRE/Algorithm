select p.product_code, sum(p.price * o.sales_amount) as SALES
from product as p join offline_sale as o on p.product_id = o.product_id
group by p.product_code
order by sales desc, p.product_code