# 1dv607 Workshop 1 - Domain Modeling

## Submission 1 - Grade 2

Pär Eriksson (pe222gq) and Oskar Emilsson (oe222ca).

![UML Domain Model - Grade 2](workshop-1-first.png)

## Final submission - Grade 2

After getting the peer reviews, decided to remove the association from Municipality, but keep it in the domain as it was a requirement and the municipality is an important part in the domain. We also keep the Authentication in the domain. In the real world it could simply be a door that requires a key.

We also removed the association between the Calendar and Booking, as that relationship does not need to persist. The Booking object remembers the booked boats and berths itself.

![UML Domain Model - Grade 2 Final](workshop-1-final.png)
