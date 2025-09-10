-- 코드를 입력하세요
SELECT LEFT(p.PRODUCT_CODE, 2) as prefix, count(*) as PRODUCTS 
FROM PRODUCT AS p GROUP BY LEFT(prefix, 2);