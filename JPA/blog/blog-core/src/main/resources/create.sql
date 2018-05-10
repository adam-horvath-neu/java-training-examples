INSERT INTO public.role( id, name)  VALUES (1,'ROLE_USER');
INSERT INTO public.role( id, name)  VALUES (2,'ROLE_BLOGGER');
INSERT INTO public."user"( id, password, username) VALUES (1,'$2a$10$I4X.U473il3rFqFcxl6UruK5TshrlXs/opqLM0hifX5Jelcm4InTG','admin');
INSERT INTO public.user_role_sw(user_id, role_id) VALUES (1, 1);
INSERT INTO public.user_role_sw(user_id, role_id) VALUES (1, 2);

