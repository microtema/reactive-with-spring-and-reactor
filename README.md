# Reactive with spring and reactor

### Reference Documentation
For better understand the benefits of the reactor-based approach, let’s look at a simple and practical example.

We’re going to build a simple notification app, which would notify users via mail – after they finish their order on an online store.

A typical synchronous implementation would naturally be bound by the throughput of the email service. Spikes in traffic, such holidays would generally be problematic.

With a reactive approach, the system can be more flexible and adapt better to failures or timeouts in these types of external systems, such as email servers.

* [Official project reactor documentation](https://projectreactor.io/docs)
