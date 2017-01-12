import psycopg2
import random

try:
    conn = psycopg2.connect("dbname='small' user='divs' host='localhost' password='password'")
    c = conn.cursor()
    # query = "CREATE TABLE Planets(Planet_Name TEXT NOT NULL, Planet_ID INT PRIMARY KEY NOT NULL)"
    # c.execute(query)
    # conn.commit()
    # query = "CREATE TABLE Aliens(Planet_ID INT references Planets(Planet_ID), Alien_ID INT PRIMARY KEY NOT NULL, Alien_Name  TEXT NOT NULL, Alien_IQ INT NOT NULL)"
    # c.execute(query)
    # conn.commit()
    print "connection attained"
    # for i in xrange(1,1000):
    #     try:
    #         Planet_Name = 'p'+str(i)
    #         Planet_ID = i
    #         query = "INSERT INTO Planets(Planet_Name, Planet_ID) VALUES ( '%s', %d);"%(Planet_Name, Planet_ID)
    #         c.execute(query)
    #         print i
    #     except:
    #         pass
    # conn.commit()

    for i in range(1, 1000):
        try:
            Planet_ID = random.randint(1, 1000)
            Alien_ID = i
            Alien_Name = 'a'+str(i)
            Alien_IQ = random.randint(1, 1000) * 10
            query = "INSERT INTO Aliens(Planet_ID, Alien_ID, Alien_Name, Alien_IQ) VALUES ( %d, %d, '%s', %d);"%(Planet_ID, Alien_ID, Alien_Name, Alien_IQ)
            c.execute(query)
        except:
            print "in except--------->",i
            pass
    conn.commit()
except StopIteration:
    print "Not able to connect to DATABASE"

