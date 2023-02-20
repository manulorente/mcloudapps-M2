ALTER TABLE test.plane ADD COLUMN (overhauljson JSON);
ALTER TABLE test.flight ADD COLUMN (crewmemberjson JSON);

UPDATE test.plane p SET p.overhauljson = (SELECT JSON_ARRAYAGG(JSON_OBJECT('id', o.id
                                                                            'start_date', o.start_date,
                                                                            'end_date', o.end_date,
                                                                            'duration', o.duration,
                                                                            'overhaul_type', o.overhaul_type,
                                                                            'overhaul_description', o.overhaul_description,
                                                                            'plane_id', o.plane_id,
                                                                            'technician_id', o.technician_id,
                                                                            'airport_id', o.airport_id)
                                            FROM test.overhaul o 
                                            WHERE o.planeid = p.id);
UPDATE test.flight f SET f.crewmemberjson = (SELECT JSON_ARRAYAGG(id) AS crewmembers
                                                FROM test.crewmember c, test.flightcrewmember fcm
                                                WHERE c.id = fcm.crewmemberid AND fcm.flightid = f.id)
                                                GROUP BY f.id);