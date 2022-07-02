# benchmark
A comparison for multiple event buses used commonly in minecraft clients


### List of event buses tested

* Zane's HomoBus
* Azura event bus
* Google's event bus
* Google's evnet bus (async)


#### Testing

* 1,000,000 itterations
* I've included benchmark artifacts in the repo so you can test yourself


### Results (on my pc)

| Event Bus   | Round 1     | Round 2     | Round 3     |
| ----------- | ----------- | ----------- | ----------- |
| HomoBus     | 18.5224ms   | 18.6562ms   | 18.658ms    |
| Azura       | 19.1913ms   | 18.6829ms   | 19.098ms    |
| Guava       | 348.301ms   | 353.3205ms  | 358.8791    |
| Guava Async | 1079.2816ms | 1063.6508ms | 1049.8528ms |
