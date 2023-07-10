insert into line_of_business(id,name)
values
    ('14be9b1f-2b4a-44d9-b0bf-e12131518a29','Ingénierie logicielle'),
    ('5e9e3533-c0a3-4be5-9fe1-133b077e46b4','Stratégie et performance d''affaires'),
    ('56678a2e-b674-4ebb-8f7e-0ac349aaa23e','Agilité et changement des organisations'),
    ('cf24320d-3bb9-4952-95aa-93e2e5876af7','Direction de projets et de programmes'),
    ('90583a56-378d-4f45-b068-8db9f6f1f3f0','Ingénierie des solutions, des processus et des systèmes'),
    ('e73ec186-d491-4f4c-af71-e4756ceb8e7a','Infonuagique et infrastructure'),
    ('ea8dbf2f-e943-4024-b73d-b74581f4e611','Cybersécurité et risques d''entreprise'),
    ('dacfbaaf-874c-46ff-a878-9a0329c048d5','Progiciel de gestion'),
    ('e3d2d587-eaa9-4e8a-b87d-aa5f7d95a0a2','Données massives, intelligence artificielle et d''affaires');

insert into job_position (id, name, line_of_business_id, job_parent_id) values
('dc47e297-9f11-424a-bafb-6758b433bb19', 'Développeur Java', '14be9b1f-2b4a-44d9-b0bf-e12131518a29', '4fa2d5a2-2539-44ad-90b8-8605583fc640'),
('4fa2d5a2-2539-44ad-90b8-8605583fc640', 'Lead Dev Java', '14be9b1f-2b4a-44d9-b0bf-e12131518a29', 'cfe3bd32-0643-4fb9-8288-cfcee496afba'),
('cfe3bd32-0643-4fb9-8288-cfcee496afba', 'Architecte Java', '14be9b1f-2b4a-44d9-b0bf-e12131518a29', null),
('81b10abd-09ab-4e4a-8fc8-9e402a624494', 'Administrateur Système', 'e73ec186-d491-4f4c-af71-e4756ceb8e7a', '083c47cb-add2-45ba-83ca-4e50b3540f49'),
('083c47cb-add2-45ba-83ca-4e50b3540f49', 'Lead Système', 'e73ec186-d491-4f4c-af71-e4756ceb8e7a', 'ea3cf8c4-865d-44cf-aa38-241a86e109aa'),
('ea3cf8c4-865d-44cf-aa38-241a86e109aa', 'Architecte Système', 'e73ec186-d491-4f4c-af71-e4756ceb8e7a',null),
('22b9b84e-4810-49ed-824f-e4c052ef4859', 'Analyste Sécurité', 'ea8dbf2f-e943-4024-b73d-b74581f4e611', '003cb935-d8d0-4a28-8fae-747da8dea688'),
('003cb935-d8d0-4a28-8fae-747da8dea688', 'Lead Analyst Sécurité', 'ea8dbf2f-e943-4024-b73d-b74581f4e611', null);

insert into technical_advisor (id, name, email, activ)
values ('28716beb-26f6-4309-ac20-e3d203a8e2d9', 'Fabrice Ngadjeu', 'fabrice.ngadjeu@gmail.com', false),
       ('8acb95b5-0a81-4335-ae67-2846848ccecf', 'Roberta Larrad', 'fabrice05@yahoo.fr', true),
       ('54008c41-ff17-467c-8d40-a17ef3092a48', 'Arlene Chaperling', 'fabrice.ngadjeu@levio.ca', true),
       ('6c02f1a0-baec-4e69-bc9c-832c81917d5b', 'Hubie Casswell', 'ngadjeu05@hotmail.com', true),
       ('4023297f-eaac-4b73-8545-078377fb0841', 'Katlin Huish', 'Katlin.Huish@levio.ca', false),
       ('7e81be69-3cba-416f-95bd-e45a513d4b8a', 'Gray Fritter', 'Gray.Fritter@levio.ca', true),
       ('db00e2de-e5f8-4c7e-9488-c99fd075f028', 'Weidar Collington', 'Weidar.Collington@levio.ca', true),
       ('5769e27f-e682-4dc5-a792-ef3c2f1b5aeb', 'Anett Astin', 'Anett.Astin@levio.ca', true),
       ('0173812a-a2b3-4dda-96b8-37f84fdc4c67', 'Antin Whetnall', 'Antin.Whetnall@levio.ca', true),
       ('62d2195d-41b5-46fd-98df-763c96378c38', 'Godard Krol', 'Godard.Krol@levio.ca', true);

insert into skill (id, level_of_expertise, job_position_id, technical_advisor_id)
values ('32bf6d54-1b5f-11ee-be56-0242ac120002', 3, 'dc47e297-9f11-424a-bafb-6758b433bb19', '28716beb-26f6-4309-ac20-e3d203a8e2d9'),
       ('32bf7056-1b5f-11ee-be56-0242ac120002', 0, 'cfe3bd32-0643-4fb9-8288-cfcee496afba', '8acb95b5-0a81-4335-ae67-2846848ccecf');


Create VIEW technical_advisor_skill_interview AS
Select ti.id technical_advisor_interview_id, ti.status,ti.created_at,ti.updated_at,ti.interview_id,ti.technical_advisor_id,
       ti.technical_default_select
        , tec.name technical_advisor_name, tec.email technical_advisor_email, tec.activ technical_advisor_activ
        ,description,interview_type,urgent,interview_status,candidate_full_name,
       job_position_candidate,level_of_expertise_candidate,recruiter_full_name,recruiter_email
From technical_advisor_interview  ti inner join interview i ON ti.interview_id = i.id
      inner join technical_advisor tec ON ti.technical_advisor_id=tec.id;

Create VIEW technical_advisor_skill_job_position AS
Select s.id skill_id,level_of_expertise,job_position_id,technical_advisor_id
     , tec.name technical_advisor_name, tec.email technical_advisor_email, tec.activ technical_advisor_activ
     , job.name job_name, line_of_business_id, job_parent_id
From skill s inner join technical_advisor tec ON s.technical_advisor_id=tec.id
             inner join job_position job ON s.job_position_id=job.id;

