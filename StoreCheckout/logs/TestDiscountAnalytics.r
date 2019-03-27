d <- read.table('~/../git/StoreCheckout/StoreCheckout/logs/Analytics.log', sep = ',', header = F)
summary(d)

#get enabled
enabled <- d[d$V3 == " Discount Applied", ]
summary(enabled)

#get disabled and a sample of same length as enabled
disabled <- d[d$V3 == " No Discount", ]
rndDisabled <- disabled[sample(nrow(disabled), length(enabled$V3)), ]
summary(rndDisabled)

#statistical test
wilcox.test(enabled$V4, rndDisabled$V4)

#median difference
median(enabled$V4)/median(rndDisabled$V4)
