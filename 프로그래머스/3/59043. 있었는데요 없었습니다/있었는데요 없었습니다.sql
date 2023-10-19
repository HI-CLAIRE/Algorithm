-- 입양보낸일(o.datetime) > 보호 시작일(i.datetime)
SELECT o.animal_id, o.name
from animal_outs as o join animal_ins as i on o.animal_id = i.animal_id
where o.datetime < i.datetime
order by i.datetime