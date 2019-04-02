INSERT INTO public.pizza (id,moddate,moduser,recdate,recuser,"version",imageurl,name,price) VALUES 
(1,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Corleone',1450)
,(2,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Colorado',1450)
,(3,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Sajtos',1290)
,(4,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Gorgonzola',1450)
,(5,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Hawai',1690)
,(6,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Kamikaze',1450)
,(7,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Lucca',1290)
,(8,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'/resources/images/pizza_cheese.jpg','Nevada',1290)
;

INSERT INTO public.topping (id,moddate,moduser,recdate,recuser,"version",name) VALUES 
(1,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'darált marhahúsos szósz')
,(2,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'hagyma')
,(3,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'paprika')
,(4,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'paradicsom')
,(5,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'mozzarella sajt')
,(6,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'fűszerezett marhahúsos szósz')
,(7,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'kukorica')
,(8,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'trappista sajt')
,(9,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'paradicsomszósz')
,(10,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'sonka')
;
INSERT INTO public.topping (id,moddate,moduser,recdate,recuser,"version",name) VALUES 
(11,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'gorgonzola sajt')
,(12,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'rukola')
,(13,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'ananász')
,(14,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'tojás')
,(15,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'bab')
,(16,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'bolognai szósz')
,(17,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'gomba')
,(18,NULL,NULL,'2019-04-01 16:51:00.000','edem',1,'szalámi')
;

INSERT INTO public.pizza_topping (pizza_id,toppings_id) VALUES 
(8,5)
,(8,7)
,(8,9)
,(8,18)
,(7,5)
,(7,9)
,(7,10)
,(7,17)
,(7,18)
,(6,4)
;
INSERT INTO public.pizza_topping (pizza_id,toppings_id) VALUES 
(6,5)
,(6,14)
,(6,15)
,(6,16)
,(5,9)
,(5,10)
,(5,13)
,(5,5)
,(5,7)
,(4,9)
;
INSERT INTO public.pizza_topping (pizza_id,toppings_id) VALUES 
(4,10)
,(4,11)
,(4,12)
,(3,8)
,(3,5)
,(3,9)
,(2,5)
,(2,7)
,(1,1)
,(1,2)
;
INSERT INTO public.pizza_topping (pizza_id,toppings_id) VALUES 
(1,3)
,(1,4)
,(1,5)
,(2,6)
;