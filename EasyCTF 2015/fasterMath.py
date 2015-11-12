import socket
import random
import math
import re
 
hostname = 'programming.easyctf.com'
port = 10300
 
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((hostname, port))
attempts = 0
for i in range(1, 101, 1):
    for j in range(1, 100, 1):
        print(s.recv(1024))
        rec = s.recv(1024)
        print(rec)
        answer = ""
        if "the operations (+, -, or x)" in rec:
            rec=rec.replace("(","s")
            rec=rec.replace(")","e")
            a = int(str(rec[(rec.index("sss")+len("sss")):rec.index(" _ ")]))
            b = int(str(rec[(rec.index(" _ ")+len(" _ ")):rec.index("e _ ")]))
            rec = rec.replace("e _ ","LOLWUT",1)
            c = int(str(rec[(rec.index("LOLWUT")+len("LOLWUT")):rec.index("e _ ")]))
            d = int(str(rec[(rec.index("e _ ")+len("e _ ")):rec.index("e = ")]))
            e = int(str(rec[(rec.index("e = ")+len("e = ")):len(rec)]))
            #print("a" + str(a) + "b" + str(b) + "c" + str(c)  + "d" + str(d)  + "e" + str(e) )
            operators = ["+", "-", "x"]
            for i in range(0,3):
                for j in range(0,3):
                    for k in range(0,3):
                        if i == 0:
                            r = a + b
                        if i == 1:
                            r = a - b
                        if i == 2:
                            r = a*b
                        if j == 0:
                            r = r + c
                        if j == 1:
                            r = r - c
                        if j == 2:
                            r = r * c
                        if k == 0:
                            r = r + d
                        if k == 1:
                            r = r - d
                        if k == 2:
                            r = r * d
                        if r == e:
                            answer = operators[i]+ operators[j] + operators[k]
                            break
        if "distance" in rec:
            v = int(str(rec[(rec.index("velocity of ")+len("velocity of ")):rec.index(" m/s.")]))
            h = int(str(rec[(rec.index("desk is ")+len("desk is ")):rec.index(" m tall")]))
            t = math.sqrt(h/5)
            answer = int(t*v)
        if "$" in rec:
            cents = float(str(rec[(rec.index("$")+len("$")):rec.index(" purchase")]))
            cents = int(cents*100)
 
            TARGET = cents
            ways = [1] + [0]*TARGET
            #coins = [1, 5, 10, 25, 100, 500]
            coins = []
            if rec.find("pennies") > -1:
                coins.append(1)
            if rec.find("nickels") > -1:
                coins.append(5)
            if rec.find("dimes") > -1:
                coins.append(10)
            if rec.find("quarters") > -1:
                coins.append(25)
            if rec.find(" dollar") > -1:
                coins.append(100)
            if rec.find("five-dollar") > -1:
                coins.append(500)
            if rec.find("ten-dollar") > -1:
                coins.append(1000)
            for coin in coins:
                for i in range(coin, TARGET+1):
                    ways[i] += ways[i-coin]
 
            print "TARGET: "+str(TARGET)
            print "coins: "+str(coins)
            print "rec"+str(rec)
            answer = ways[TARGET]
    
        if "root" in rec:
            #root:386x^2-213072x+26482302
            rec = rec.replace(" ","")
            a = int(str(rec[(rec.index("root:")+len("root:")):rec.index("x^2")]))
            rec = rec.replace("x^2","y^2")
            b = int(str(rec[(rec.index("y^2")+len("y^2")):rec.index("x")]))
            c = int(str(rec[(rec.index("x")+len("x")):len(rec)]))
            x1 = (-b+math.sqrt((b**2)-(4*(a*c))))/(2*a)
            x2 = (-b-math.sqrt((b**2)-(4*(a*c))))/(2*a)
            if "greater" in rec:
                answer = int(max(x1, x2))
            if "lesser" in rec:
                answer = int(min(x1, x2))
 
 
        print (answer)
        attempts = attempts + 1
        print ("attempts: " + str(attempts))
        s.sendall(str(answer))
 
        if not "Solve this problem in" in rec:
            break
            break