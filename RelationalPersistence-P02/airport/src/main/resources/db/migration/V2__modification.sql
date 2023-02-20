ALTER TABLE `plane` ADD COLUMN (overhauls_json JSON);

UPDATE `plane` p SET p.overhauls_json = (SELECT JSON_ARRAYAGG(JSON_OBJECT('id', o.id,
                                                                            'start_date', o.start_date,
                                                                            'end_date', o.end_date,
                                                                            'duration', o.duration,
                                                                            'overhaul_type', o.overhaul_type,
                                                                            'overhaul_description', o.overhaul_description,
                                                                            'plane_id', o.plane_id,
                                                                            'technician_id', o.technician_id,
                                                                            'airport_id', o.airport_id))
                                            FROM test.overhaul o 
                                            WHERE p.id= o.plane_id);

ALTER TABLE `flight` ADD COLUMN (crewmember_json JSON);

UPDATE `flight` f SET f.crewmember_json = (SELECT JSON_ARRAYAGG(id) AS crewmembers
                                                FROM test.crew_member c, test.flight_crew_member fcm
                                                WHERE c.id = fcm.crew_member_id AND fcm.flight_id = f.id
                                                GROUP BY f.id);