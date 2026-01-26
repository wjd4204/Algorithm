-- 코드를 입력하세요
SELECT MCDP_CD AS '진료과코드', count(*) AS '5월예약건수' 
from APPOINTMENT AS AM 
where YEAR(APNT_YMD) = 2022 and MONTH(APNT_YMD) = 5
group by MCDP_CD 
order by count(*), MCDP_CD;