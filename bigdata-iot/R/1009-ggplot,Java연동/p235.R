install.packages("googleVis")
library(googleVis)

motion <- gvisMotionChart(economics, idvar = "psavert", timevar = "date")
plot(motion)
