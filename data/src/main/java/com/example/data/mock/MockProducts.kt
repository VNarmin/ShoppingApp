package com.example.data.mock

import com.example.data.dto.CategoryDTO
import com.example.data.dto.ProductDTO

object MockProducts {
    val all = listOf(

        // --- SHOES ---
        ProductDTO(
            productID = "shoes_1",
            name = "Nike Air Max 270",
            description = "The Nike Air Max 270 was designed to keep you moving from morning to night without sacrificing style. A breathable mesh upper wraps your foot in lightweight support, while the responsive Air cushioning absorbs every step and gives energy back to your stride. Whether you're commuting, running errands, or just spending long hours on your feet, these shoes deliver the kind of all-day comfort that makes you forget you're even wearing them.",
            price = 129.00,
            images = listOf("#6366F1", "#E85A4F", "#32D583"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 10,
            rating = 4.8,
            reviewCount = 128
        ),
        ProductDTO(
            productID = "shoes_2",
            name = "Retro Runner",
            description = "The Retro Runner takes everything you loved about classic running shoes and rebuilds it for today's streets. A vintage-inspired sole unit has been updated with modern cushioning technology so you get the look of the past without sacrificing the comfort of the present. The clean silhouette pairs easily with casual outfits, making it a shoe you'll find yourself reaching for day after day.",
            price = 99.00,
            images = listOf("#E85A4F", "#6366F1", "#32D583"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 5,
            rating = 4.5,
            reviewCount = 86
        ),
        ProductDTO(
            productID = "shoes_3",
            name = "Sport Sandal",
            description = "The Sport Sandal was built for people who refuse to slow down, even in warm weather. Fully adjustable straps let you dial in a secure fit whether you're hiking a trail or walking through town, and the contoured footbed supports your arch through long days on your feet. A grippy rubber outsole bites into both wet and dry surfaces, so you can move with confidence no matter where the day takes you.",
            price = 74.00,
            images = listOf("#32D583", "#6366F1", "#E85A4F"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 8,
            rating = 4.3,
            reviewCount = 54
        ),
        ProductDTO(
            productID = "shoes_4",
            name = "Classic Sneaker",
            description = "Some shoes try to do too much, but the Classic Sneaker knows exactly what it is. A premium leather upper ages beautifully over time, developing character the more you wear it, while a cushioned insole keeps your feet comfortable through whatever the day demands. The low-top silhouette works just as well with jeans and a jacket as it does with shorts and a t-shirt, making it one of the most versatile shoes you'll ever own.",
            price = 110.00,
            images = listOf("#FFB547", "#6366F1", "#E85A4F"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 12,
            rating = 4.6,
            reviewCount = 210
        ),
        ProductDTO(
            productID = "shoes_5",
            name = "Trail Boot",
            description = "The Trail Boot was engineered to handle whatever nature throws at it without making you feel weighed down. A fully waterproof construction keeps your feet dry when you cross streams or get caught in the rain, while an aggressive lug sole digs into mud, gravel and loose ground to keep you planted on every step. Reinforced ankle support reduces fatigue on long descents and helps protect against rolls on uneven terrain.",
            price = 145.00,
            images = listOf("#6366F1", "#E85A4F", "#FFB547"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 7,
            rating = 4.7,
            reviewCount = 93
        ),
        ProductDTO(
            productID = "shoes_6",
            name = "Canvas Low",
            description = "The Canvas Low has been a wardrobe staple for decades, and it earns that status by being exactly what you need it to be. A clean canvas upper sits on a vulcanized rubber sole that gives you just enough grip and flexibility for everyday wear. Available in twelve colorways ranging from clean neutrals to bold seasonal tones, it pairs with almost anything you already own and looks better the more you wear it.",
            price = 59.00,
            images = listOf("#E85A4F", "#6366F1", "#FFB547"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 20,
            rating = 4.2,
            reviewCount = 341
        ),
        ProductDTO(
            productID = "shoes_7",
            name = "Running Pro",
            description = "The Running Pro was built around one goal: helping you run faster and recover faster at the same time. A carbon fiber plate embedded in the midsole stores energy as your foot compresses and releases it explosively at toe-off, propelling you forward with every stride. The lightweight foam compound absorbs impact on landing and stays responsive mile after mile, so your legs feel fresher at the end of a long run than you'd expect.",
            price = 179.00,
            images = listOf("#32D583", "#6366F1", "#FFB547"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 4,
            rating = 4.9,
            reviewCount = 67
        ),
        ProductDTO(
            productID = "shoes_8",
            name = "Slip-On Loafer",
            description = "The Slip-On Loafer bridges the gap between polished and comfortable in a way that most shoes never manage to achieve. A full-grain leather upper gives it the kind of refined look that works in professional settings, while a cushioned footbed and flexible outsole make it genuinely pleasant to wear through long workdays or evening events. You can go from the office to dinner without changing your shoes and without compromising on either front.",
            price = 95.00,
            images = listOf("#FFB547", "#6366F1", "#32D583"),
            category = CategoryDTO(categoryID = "shoes", displayName = "Shoes", itemCount = 128),
            stockCount = 9,
            rating = 4.4,
            reviewCount = 112
        ),

        // --- BAGS ---
        ProductDTO(
            productID = "bags_1",
            name = "Leather Tote Bag",
            description = "The Leather Tote Bag is made from full-grain leather that develops a rich patina the more you use it, so it actually looks better after years of daily wear than it did when you first bought it. Interior pockets keep your essentials organized so you're not digging through a single cavernous space, and a magnetic closure snaps shut quickly when you're on the move. Spacious enough to carry a laptop, notebooks and everything else you need for a full workday or a weekend getaway.",
            price = 89.00,
            images = listOf("#6366F1", "#32D583", "#E85A4F"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 7,
            rating = 4.7,
            reviewCount = 93
        ),
        ProductDTO(
            productID = "bags_2",
            name = "Canvas Backpack",
            description = "The Canvas Backpack was designed for people who carry a lot and need it all to stay organized. A padded laptop sleeve protects your computer from bumps and drops, while multiple interior and exterior compartments give every item its own home so you can find things without unpacking the whole bag. The lightweight canvas construction means you're not adding unnecessary weight before you've even packed anything.",
            price = 65.00,
            images = listOf("#E85A4F", "#32D583", "#6366F1"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 15,
            rating = 4.4,
            reviewCount = 147
        ),
        ProductDTO(
            productID = "bags_3",
            name = "Crossbody Bag",
            description = "The Crossbody Bag solves the problem of carrying your essentials without letting a bag slow you down. A compact silhouette fits your phone, wallet, keys and cards comfortably without adding bulk, and an adjustable strap lets you position it exactly where you want it across your body. The zip closure keeps everything secure whether you're navigating a crowded market or catching public transport.",
            price = 55.00,
            images = listOf("#32D583", "#E85A4F", "#6366F1"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 11,
            rating = 4.5,
            reviewCount = 88
        ),
        ProductDTO(
            productID = "bags_4",
            name = "Weekender Duffel",
            description = "The Weekender Duffel holds everything you need for two or three nights away without forcing you to check a bag at the airport. A dedicated shoe compartment keeps your footwear separate from your clothes, and the main compartment is large enough to pack generously without having to roll everything tightly. A detachable shoulder strap gives you the option to carry it across your body when your hands are full with other luggage.",
            price = 115.00,
            images = listOf("#FFB547", "#E85A4F", "#6366F1"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 6,
            rating = 4.6,
            reviewCount = 72
        ),
        ProductDTO(
            productID = "bags_5",
            name = "Mini Bucket Bag",
            description = "The Mini Bucket Bag proves that small bags can carry more personality than larger ones. Crafted from pebbled leather with a drawstring closure and a delicate chain strap, it transitions effortlessly from a daytime accessory to an evening bag without missing a beat. The compact silhouette encourages you to carry only what you actually need, which turns out to be less than you think.",
            price = 79.00,
            images = listOf("#6366F1", "#32D583", "#FFB547"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 9,
            rating = 4.3,
            reviewCount = 61
        ),
        ProductDTO(
            productID = "bags_6",
            name = "Laptop Briefcase",
            description = "The Laptop Briefcase was designed for professionals who need their bag to work as hard as they do. A padded compartment protects laptops up to 15 inches from the kind of everyday impacts that come with commuting and travel, and the TSA-friendly layout means you can move through airport security without unpacking everything. A water-resistant exterior keeps your belongings protected on rainy commutes or unexpected downpours.",
            price = 135.00,
            images = listOf("#E85A4F", "#32D583", "#FFB547"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 8,
            rating = 4.8,
            reviewCount = 104
        ),
        ProductDTO(
            productID = "bags_7",
            name = "Gym Bag",
            description = "The Gym Bag was built specifically around the reality of carrying workout gear, which means it solves all the problems that generic bags ignore. A ventilated shoe pocket keeps your sneakers separated from your clean clothes, and a wet/dry divider means your sweaty post-workout kit stays isolated from everything else in the bag. A side water bottle holder keeps hydration within easy reach so you're not digging through the main compartment between sets.",
            price = 48.00,
            images = listOf("#32D583", "#E85A4F", "#FFB547"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 18,
            rating = 4.4,
            reviewCount = 193
        ),
        ProductDTO(
            productID = "bags_8",
            name = "Clutch Wallet",
            description = "The Clutch Wallet is the kind of accessory that earns its place in your rotation by doing exactly what you need it to do without any unnecessary extras. Multiple card slots organize your cards and cash, and the zip-around closure keeps everything secure whether it's sitting in a larger bag or being carried in your hand with the wrist strap. Made from genuine leather that softens and molds to your daily use over time.",
            price = 42.00,
            images = listOf("#FFB547", "#E85A4F", "#32D583"),
            category = CategoryDTO(categoryID = "bags", displayName = "Bags", itemCount = 86),
            stockCount = 14,
            rating = 4.2,
            reviewCount = 57
        ),

        // --- WATCHES ---
        ProductDTO(
            productID = "watches_1",
            name = "Minimal Watch",
            description = "The Minimal Watch was designed on the belief that a great watch should tell the time beautifully and then get out of the way. A Swiss movement ticks reliably inside a clean case topped with sapphire crystal glass that resists scratches far better than standard mineral glass. The uncluttered dial reads instantly at a glance, and water resistance to 50 meters means you never have to think twice about wearing it in the rain or at the sink.",
            price = 215.00,
            images = listOf("#6366F1", "#FFB547", "#E85A4F"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 4,
            rating = 4.9,
            reviewCount = 62
        ),
        ProductDTO(
            productID = "watches_2",
            name = "Sport Chronograph",
            description = "The Sport Chronograph gives you the tools to measure your performance without compromising on everyday wearability. A tachymeter bezel lets you calculate speed and distance, while three subdials track elapsed hours, minutes and seconds during any activity you want to time. Luminous hands and markers stay readable in low light, and water resistance to 100 meters means it keeps pace with you whether you're training on land or in water.",
            price = 189.00,
            images = listOf("#E85A4F", "#FFB547", "#6366F1"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 6,
            rating = 4.6,
            reviewCount = 44
        ),
        ProductDTO(
            productID = "watches_3",
            name = "Dress Watch",
            description = "The Dress Watch represents the kind of restraint that takes real confidence to wear. An ultra-thin case sits elegantly on the wrist without drawing attention to itself, while a guilloché-patterned dial catches light in a way that feels refined rather than flashy. A genuine leather strap completes the look with the kind of understated elegance that suits formal occasions, important meetings, or any moment when you want to make a quiet but lasting impression.",
            price = 299.00,
            images = listOf("#32D583", "#FFB547", "#6366F1"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 3,
            rating = 4.8,
            reviewCount = 38
        ),
        ProductDTO(
            productID = "watches_4",
            name = "Diver Watch",
            description = "The Diver Watch was engineered to perform at depths that most people will never reach, and that engineering translates into a watch you can trust in any situation. A unidirectional bezel lets you track elapsed dive time safely, and a helium escape valve protects the movement during saturation diving. Water resistance to 300 meters goes well beyond what recreational divers need, giving you a serious margin of safety whether you're diving professionally or just swimming laps.",
            price = 245.00,
            images = listOf("#FFB547", "#32D583", "#6366F1"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 5,
            rating = 4.7,
            reviewCount = 51
        ),
        ProductDTO(
            productID = "watches_5",
            name = "Smart Watch",
            description = "The Smart Watch tracks the metrics that actually matter for your health and performance without turning your wrist into a cluttered screen. Built-in GPS maps your runs, rides and hikes accurately without needing your phone nearby, while continuous heart rate monitoring gives you real-time feedback during workouts and recovery. An always-on AMOLED display stays readable in direct sunlight, and a five-day battery means you're charging it twice a week rather than every night.",
            price = 179.00,
            images = listOf("#6366F1", "#FFB547", "#32D583"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 12,
            rating = 4.5,
            reviewCount = 287
        ),
        ProductDTO(
            productID = "watches_6",
            name = "Field Watch",
            description = "The Field Watch draws its design language from military timepieces built to perform reliably in demanding conditions, then refines that aesthetic into something you'd genuinely want to wear every day. A canvas strap sits comfortably on the wrist through long days of activity, and large luminous Arabic numerals remain easy to read in the dark or under pressure. The robust stainless steel case shrugs off the kind of everyday bumps and knocks that would damage more delicate watches.",
            price = 139.00,
            images = listOf("#E85A4F", "#FFB547", "#32D583"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 8,
            rating = 4.4,
            reviewCount = 76
        ),
        ProductDTO(
            productID = "watches_7",
            name = "Pilot Watch",
            description = "The Pilot Watch carries the heritage of aviation horology in every design detail, from the large legible dial that was originally sized for reading in a cockpit to the circular slide rule bezel that pilots once used to calculate fuel consumption and flight time. A flyback chronograph lets you reset and restart timing with a single button press, which is exactly what you need when precision matters. Wearing one doesn't just tell people the time — it tells them something about how you think.",
            price = 349.00,
            images = listOf("#32D583", "#FFB547", "#E85A4F"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 2,
            rating = 4.9,
            reviewCount = 29
        ),
        ProductDTO(
            productID = "watches_8",
            name = "Rose Gold Watch",
            description = "The Rose Gold Watch finds the balance between feminine elegance and contemporary minimalism that so many watches in its category miss entirely. A rose gold PVD case resists scratches and tarnishing better than plated alternatives, keeping its warm color consistent over years of daily wear. A mother-of-pearl dial shifts subtly in different lighting conditions, and a mesh bracelet lies flat against the wrist in a way that feels as comfortable as it looks polished.",
            price = 165.00,
            images = listOf("#FFB547", "#32D583", "#E85A4F"),
            category = CategoryDTO(categoryID = "watches", displayName = "Watches", itemCount = 54),
            stockCount = 7,
            rating = 4.6,
            reviewCount = 83
        ),

        // --- TECH ---
        ProductDTO(
            productID = "tech_1",
            name = "Wireless Earbuds",
            description = "The Wireless Earbuds use active noise cancellation to remove the world around you so you can focus on whatever you're listening to, whether that's music, a podcast, or a call that requires your full attention. A 24-hour total battery life with the charging case means you can go days between charges under normal use, and IPX4 water resistance makes them safe to wear through workouts and light rain. The audio tuning prioritizes clarity across the full frequency range rather than boosting bass at the expense of detail.",
            price = 149.00,
            images = listOf("#6366F1", "#E85A4F", "#32D583"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 20,
            rating = 4.7,
            reviewCount = 312
        ),
        ProductDTO(
            productID = "tech_2",
            name = "Smart Band",
            description = "The Smart Band monitors your health continuously throughout the day and night without demanding your attention the way a full smartwatch does. It tracks steps, heart rate, sleep stages and stress levels in the background while you get on with your life, then surfaces insights in a companion app that helps you understand patterns over time. A seven-day battery life means you can wear it through a full week without interruption, and swim-proof construction means you never need to take it off.",
            price = 59.00,
            images = listOf("#E85A4F", "#6366F1", "#32D583"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 18,
            rating = 4.3,
            reviewCount = 178
        ),
        ProductDTO(
            productID = "tech_3",
            name = "Portable Speaker",
            description = "The Portable Speaker fills a room with 360-degree sound that projects equally in all directions, so the music sounds the same wherever people are standing rather than fading as you move away from the front of the speaker. A 20-hour battery keeps it playing through the longest days and evenings without needing a recharge, and IP67 waterproofing means it handles poolside splashes, beach trips and unexpected rain without any anxiety on your part.",
            price = 89.00,
            images = listOf("#32D583", "#6366F1", "#E85A4F"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 14,
            rating = 4.6,
            reviewCount = 224
        ),
        ProductDTO(
            productID = "tech_4",
            name = "Wireless Charger",
            description = "The Wireless Charger delivers up to 15W of fast wireless power to any Qi-compatible device, which covers virtually every modern smartphone and a growing number of earbuds and smartwatches. You simply set your device down and charging begins automatically, without fumbling for a cable in the dark or wearing out a charging port over thousands of connection cycles. A slim profile and non-slip surface keep it tidy on a desk or nightstand without taking up more space than necessary.",
            price = 35.00,
            images = listOf("#FFB547", "#6366F1", "#E85A4F"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 30,
            rating = 4.4,
            reviewCount = 416
        ),
        ProductDTO(
            productID = "tech_5",
            name = "USB-C Hub",
            description = "The USB-C Hub turns a single USB-C port into a complete connectivity setup, which makes it particularly valuable for modern laptops that have traded port variety for thinness. A 4K HDMI output connects to external monitors and TVs, 100W USB-C Power Delivery charges your laptop while you work, three USB-A ports handle legacy peripherals and flash drives, and SD plus microSD slots handle memory cards from cameras and drones without needing additional adapters.",
            price = 49.00,
            images = listOf("#6366F1", "#E85A4F", "#FFB547"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 22,
            rating = 4.5,
            reviewCount = 189
        ),
        ProductDTO(
            productID = "tech_6",
            name = "Mechanical Keyboard",
            description = "The Mechanical Keyboard was built for people who spend hours at a keyboard every day and have decided that the typing experience should feel as good as the work that comes from it. A compact 75% layout keeps your hands closer together than a full-size keyboard, reducing shoulder strain over long sessions, while hot-swap switch sockets let you change the feel of every keystroke without any soldering. Per-key RGB lighting runs through millions of color combinations, and an aluminum case gives the whole thing a satisfying weight and rigidity.",
            price = 129.00,
            images = listOf("#E85A4F", "#6366F1", "#FFB547"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 9,
            rating = 4.8,
            reviewCount = 143
        ),
        ProductDTO(
            productID = "tech_7",
            name = "Webcam 4K",
            description = "The Webcam 4K captures your video at four times the resolution of standard 1080p webcams, which means your image stays sharp even when shared screens or video compression reduce quality on the receiving end. A fast autofocus system tracks your face smoothly as you move rather than hunting for focus in a distracting way, and dual built-in stereo microphones pick up your voice clearly without needing a separate microphone for most calls. A physical privacy cover snaps shut over the lens when you're not using it.",
            price = 99.00,
            images = listOf("#32D583", "#6366F1", "#FFB547"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 11,
            rating = 4.6,
            reviewCount = 97
        ),
        ProductDTO(
            productID = "tech_8",
            name = "Power Bank 20000",
            description = "The Power Bank 20000 carries enough capacity to charge a modern smartphone roughly five times over, making it the kind of battery pack you can rely on through multi-day trips without worrying about running out of power. A 65W USB-C Power Delivery output is strong enough to charge most laptops at full speed, not just keep them ticking over, and the two additional ports let you charge your phone and earbuds at the same time without slowing anything down.",
            price = 69.00,
            images = listOf("#FFB547", "#6366F1", "#32D583"),
            category = CategoryDTO(categoryID = "tech", displayName = "Tech", itemCount = 210),
            stockCount = 25,
            rating = 4.7,
            reviewCount = 531
        ),

        // --- BEAUTY ---
        ProductDTO(
            productID = "beauty_1",
            name = "Glow Serum",
            description = "The Glow Serum combines a stabilized Vitamin C complex with hyaluronic acid to address two of the most common skin concerns at the same time: uneven tone and dehydration. Vitamin C works to interrupt the melanin production process that causes dark spots and post-blemish marks, gradually evening out your complexion over consistent use, while hyaluronic acid draws moisture into the skin and holds it there through the day. Most users notice a visible improvement in brightness and skin clarity within four weeks of daily application.",
            price = 45.00,
            images = listOf("#6366F1", "#32D583", "#E85A4F"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 25,
            rating = 4.8,
            reviewCount = 423
        ),
        ProductDTO(
            productID = "beauty_2",
            name = "Matte Lipstick",
            description = "The Matte Lipstick delivers the flat, saturated color of a traditional matte formula without the dryness and discomfort that matte lipsticks used to be known for. A moisturizing core keeps your lips hydrated through up to 12 hours of wear so they don't feel tight or flaky by the end of the day, and the transfer-resistant formula stays where you put it through meals, drinks and everything else. Available in 24 shades spanning nudes, berries, reds and bold editorial tones.",
            price = 22.00,
            images = listOf("#E85A4F", "#32D583", "#6366F1"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 30,
            rating = 4.5,
            reviewCount = 289
        ),
        ProductDTO(
            productID = "beauty_3",
            name = "Hydrating Moisturizer",
            description = "The Hydrating Moisturizer uses a combination of ceramides and niacinamide to repair and strengthen the skin barrier while delivering lasting hydration that doesn't evaporate by midday. Ceramides replace the lipids that the skin barrier loses through daily exposure to environmental stressors, while niacinamide calms redness, minimizes the appearance of pores and improves overall skin texture over time. A lightweight gel-cream texture absorbs quickly without leaving a greasy residue, making it suitable for all skin types including oily and combination skin.",
            price = 38.00,
            images = listOf("#32D583", "#E85A4F", "#6366F1"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 20,
            rating = 4.7,
            reviewCount = 512
        ),
        ProductDTO(
            productID = "beauty_4",
            name = "Eye Shadow Palette",
            description = "The Eye Shadow Palette brings together 12 shades that work together as a complete system rather than 12 unrelated colors that happen to share a compact. Matte shades lay down clean, flat color for building definition in the crease and lining the lash line, while shimmer and foil finishes catch light on the lid and inner corner for dimension and brightness. The highly pigmented formula means the colors appear true-to-pan on the eye without requiring heavy layering, and the blendable texture lets you soften edges without muddying the colors.",
            price = 34.00,
            images = listOf("#FFB547", "#E85A4F", "#6366F1"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 17,
            rating = 4.6,
            reviewCount = 376
        ),
        ProductDTO(
            productID = "beauty_5",
            name = "SPF 50 Sunscreen",
            description = "The SPF 50 Sunscreen provides broad-spectrum protection against both UVA rays that age the skin and UVB rays that burn it, with a lightweight formula that disappears into the skin rather than sitting on top of it. There is no white cast on any skin tone, which removes the main reason people skip sunscreen when they're in a hurry, and the reef-safe formulation uses mineral and organic UV filters that don't contribute to coral reef damage. Dermatologist-tested and suitable for daily use on the face and body.",
            price = 28.00,
            images = listOf("#6366F1", "#32D583", "#FFB547"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 35,
            rating = 4.8,
            reviewCount = 634
        ),
        ProductDTO(
            productID = "beauty_6",
            name = "Hair Growth Serum",
            description = "The Hair Growth Serum was developed around the science of follicle health rather than the kind of superficial conditioning that most hair products focus on. Caffeine penetrates the scalp to stimulate circulation around hair follicles and extend the active growth phase of the hair cycle, while biotin provides the keratin-building blocks that strengthen each strand from root to tip. With consistent daily application to the scalp, most users see a measurable reduction in breakage and shedding within eight weeks.",
            price = 52.00,
            images = listOf("#E85A4F", "#32D583", "#FFB547"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 13,
            rating = 4.4,
            reviewCount = 198
        ),
        ProductDTO(
            productID = "beauty_7",
            name = "Perfume Eau de Parfum",
            description = "The Perfume Eau de Parfum opens with a burst of bright jasmine before settling into a warm heart of sandalwood and amber that develops differently on every person who wears it. The concentration of fragrance oils in an Eau de Parfum formula means the scent projects noticeably for the first few hours and then lingers close to the skin for the rest of the day, so you don't need to reapply. The woody floral character works across seasons and occasions, making it the kind of fragrance you return to rather than rotate out.",
            price = 78.00,
            images = listOf("#32D583", "#E85A4F", "#FFB547"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 10,
            rating = 4.9,
            reviewCount = 147
        ),
        ProductDTO(
            productID = "beauty_8",
            name = "Retinol Night Cream",
            description = "The Retinol Night Cream uses a 0.3% retinol concentration that sits in the effective range for visible anti-aging results without the intense irritation that higher concentrations cause in most skin types. Retinol accelerates cell turnover overnight, gradually reducing the appearance of fine lines and improving skin texture over consistent use, while a peptide complex supports collagen production and squalane seals in moisture to counteract the dryness that retinol can sometimes cause. Apply every night as the last step in your skincare routine and expect to see meaningful changes in your skin's surface texture within six to eight weeks.",
            price = 62.00,
            images = listOf("#FFB547", "#E85A4F", "#32D583"),
            category = CategoryDTO(categoryID = "beauty", displayName = "Beauty", itemCount = 97),
            stockCount = 16,
            rating = 4.7,
            reviewCount = 283
        ),

        // --- SPORTS ---
        ProductDTO(
            productID = "sports_1",
            name = "Yoga Mat Pro",
            description = "The Yoga Mat Pro gives you a stable, non-slip surface that holds its grip whether your hands are dry at the start of practice or sweaty by the end of it. Alignment lines printed across the surface help you position your hands, feet and hips correctly in foundational poses, which is particularly useful when you're building a home practice without an instructor watching your form. The 6mm thickness cushions your knees and wrists on hard floors without being so thick that you lose the ground connection that balance poses require.",
            price = 48.00,
            images = listOf("#6366F1", "#FFB547", "#E85A4F"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 14,
            rating = 4.6,
            reviewCount = 167
        ),
        ProductDTO(
            productID = "sports_2",
            name = "Resistance Bands Set",
            description = "The Resistance Bands Set gives you five distinct resistance levels in a single package, which means you can scale any exercise up or down depending on the muscle group you're targeting or how fatigued you are. A door anchor attachment lets you set up pulling and pressing movements that would otherwise require a cable machine, and foam-padded handles make extended sets more comfortable on your hands. The latex construction stretches consistently under load without the snapping and losing tension that cheaper bands develop over time.",
            price = 35.00,
            images = listOf("#E85A4F", "#FFB547", "#6366F1"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 22,
            rating = 4.4,
            reviewCount = 98
        ),
        ProductDTO(
            productID = "sports_3",
            name = "Adjustable Dumbbells",
            description = "The Adjustable Dumbbells replace an entire rack of fixed-weight dumbbells with a single pair that takes up roughly the space of two shoeboxes. A quick-change dial mechanism lets you select your weight in seconds between sets, adjusting in 2.5kg increments from 2.5kg up to 25kg per dumbbell, so you never have to interrupt your workout to swap equipment. The compact footprint makes them ideal for home gyms where space is limited but the need for progressive overload is exactly the same as in a commercial facility.",
            price = 189.00,
            images = listOf("#32D583", "#FFB547", "#6366F1"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 6,
            rating = 4.8,
            reviewCount = 214
        ),
        ProductDTO(
            productID = "sports_4",
            name = "Jump Rope",
            description = "The Jump Rope was designed specifically for speed work, which means the cable spins faster and more consistently than the weighted ropes used for general fitness. Ball-bearing handles eliminate the friction that causes cheaper ropes to slow down and tangle during fast footwork, and the adjustable steel cable lets you set the exact length that suits your height and jumping style. Whether you're building cardio capacity, working on double-unders for CrossFit, or just adding jump rope intervals to your warm-up, the mechanics stay smooth and predictable.",
            price = 18.00,
            images = listOf("#FFB547", "#32D583", "#6366F1"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 40,
            rating = 4.5,
            reviewCount = 302
        ),
        ProductDTO(
            productID = "sports_5",
            name = "Foam Roller",
            description = "The Foam Roller applies sustained pressure to tight muscles and connective tissue in a way that promotes blood flow and helps break up the adhesions that develop from training, sitting at a desk or simply not moving enough through the day. A textured surface creates varying pressure across different contact points, which more closely mimics the effect of hands-on massage than a smooth roller does. High-density EVA foam holds its shape under bodyweight without compressing flat over time the way cheaper foam rollers tend to.",
            price = 29.00,
            images = listOf("#6366F1", "#FFB547", "#32D583"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 19,
            rating = 4.3,
            reviewCount = 88
        ),
        ProductDTO(
            productID = "sports_6",
            name = "Water Bottle 1L",
            description = "The Water Bottle 1L uses double-wall vacuum insulation to create a thermal barrier between the liquid inside and the temperature outside, keeping cold drinks cold for up to 24 hours and hot drinks hot for up to 12 hours regardless of ambient temperature. The stainless steel construction doesn't absorb odors or flavors the way plastic bottles do over time, so your water always tastes like water rather than yesterday's coffee. A leak-proof lid seals completely under pressure, which means you can pack it horizontally in a bag without covering everything else in liquid.",
            price = 32.00,
            images = listOf("#E85A4F", "#FFB547", "#32D583"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 28,
            rating = 4.7,
            reviewCount = 445
        ),
        ProductDTO(
            productID = "sports_7",
            name = "Pull-Up Bar",
            description = "The Pull-Up Bar installs in any standard doorframe without drilling holes or using any tools, relying instead on a leverage system that distributes your bodyweight against the frame rather than relying on screws that can loosen over time. The foam-padded grips reduce hand fatigue during longer sets and protect the doorframe from scratches, and the design supports up to 150kg of bodyweight so it works for virtually every user. When you're done training, the bar comes down in seconds and stores flat without taking up any meaningful space.",
            price = 44.00,
            images = listOf("#32D583", "#FFB547", "#E85A4F"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 11,
            rating = 4.5,
            reviewCount = 176
        ),
        ProductDTO(
            productID = "sports_8",
            name = "Gym Gloves",
            description = "The Gym Gloves protect your palms from the calluses and skin tears that develop from repeated contact with barbells, dumbbells and pull-up bars, while a non-slip silicone grip pattern maintains your hold on equipment even when your hands get sweaty during intense sets. A half-finger design leaves your fingertips exposed for better bar feel and dexterity, and integrated wrist support wraps around the joint to reduce strain during pressing movements. The machine-washable construction means you can clean them regularly without worrying about them falling apart.",
            price = 24.00,
            images = listOf("#FFB547", "#32D583", "#E85A4F"),
            category = CategoryDTO(categoryID = "sports", displayName = "Sports", itemCount = 64),
            stockCount = 33,
            rating = 4.4,
            reviewCount = 129
        ),

        // --- CLOTHING ---
        ProductDTO(
            productID = "clothing_1",
            name = "Classic White Tee",
            description = "The Classic White Tee is made from 100% organic cotton that feels noticeably softer against the skin than conventional cotton, partly because of the fabric quality and partly because it's been pre-shrunk so it keeps its shape and fit through repeated washing. A relaxed fit sits comfortably without clinging, and a reinforced crew neckline holds its shape rather than stretching out after a few wears the way cheaper tees tend to. It layers under shirts and jackets as well as it stands alone, which makes it one of the highest-value pieces you can add to your wardrobe.",
            price = 29.00,
            images = listOf("#6366F1", "#E85A4F", "#32D583"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 45,
            rating = 4.6,
            reviewCount = 587
        ),
        ProductDTO(
            productID = "clothing_2",
            name = "Slim Fit Chinos",
            description = "The Slim Fit Chinos are cut from a stretch cotton blend that moves with your body rather than restricting it, which makes a significant difference if you spend your day going between a desk, meetings and commuting. A slim taper from the knee down gives them a clean, modern silhouette that works in smart-casual and business-casual settings without looking like suit trousers, and a hidden waistband adjustment lets you fine-tune the fit without the waistband showing. A wrinkle-resistant finish means they look presentable at the end of a long day without needing to be ironed every time.",
            price = 69.00,
            images = listOf("#E85A4F", "#6366F1", "#32D583"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 22,
            rating = 4.5,
            reviewCount = 234
        ),
        ProductDTO(
            productID = "clothing_3",
            name = "Merino Wool Sweater",
            description = "The Merino Wool Sweater is knitted from extra-fine merino fibers that are thin enough to sit directly against the skin without any of the scratching or itching that coarser wool varieties cause. Merino naturally regulates temperature by absorbing and releasing moisture in response to your body heat, which means it keeps you warm in the cold and comfortable when you move indoors without overheating. A classic crew neck silhouette works over shirts, under jackets and on its own, and unlike most wool garments, it goes safely in the washing machine on a gentle cycle.",
            price = 119.00,
            images = listOf("#32D583", "#6366F1", "#E85A4F"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 14,
            rating = 4.8,
            reviewCount = 193
        ),
        ProductDTO(
            productID = "clothing_4",
            name = "Linen Shirt",
            description = "The Linen Shirt is cut from a relaxed fit that allows air to circulate freely around your body, which makes it noticeably cooler to wear in warm weather than cotton or synthetic alternatives. Linen fibers become softer and more comfortable with every wash, so the shirt you wear at the end of summer feels better than the one you put on at the beginning of it. A button-down collar keeps the look neat and intentional whether you wear it tucked or untucked, open over a t-shirt or buttoned up on its own.",
            price = 55.00,
            images = listOf("#FFB547", "#6366F1", "#E85A4F"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 18,
            rating = 4.4,
            reviewCount = 142
        ),
        ProductDTO(
            productID = "clothing_5",
            name = "Puffer Jacket",
            description = "The Puffer Jacket uses recycled polyester fill that provides the same warmth-to-weight ratio as premium down while remaining ethical and performing better in wet conditions where down tends to clump and lose insulating properties. A DWR surface coating causes water to bead and roll off the outer shell rather than soaking through, keeping the fill dry and effective even in light rain or snow. When you don't need it, the jacket compresses and packs into its own internal pocket, turning into a bundle roughly the size of a water bottle.",
            price = 149.00,
            images = listOf("#6366F1", "#E85A4F", "#FFB547"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 9,
            rating = 4.7,
            reviewCount = 278
        ),
        ProductDTO(
            productID = "clothing_6",
            name = "Jogger Pants",
            description = "The Jogger Pants are cut from a heavyweight French terry fabric that has enough structure to look intentional in casual settings while remaining as comfortable as sweatpants when you're at home. A tapered fit from the knee to the ribbed cuff gives them a clean silhouette that works better with most footwear than a straight or wide-leg cut, and YKK zip pockets on both sides keep your valuables secure whether you're running errands or sitting on public transport. The waistband sits comfortably through long periods of wear without digging in or rolling down.",
            price = 59.00,
            images = listOf("#E85A4F", "#6366F1", "#FFB547"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 27,
            rating = 4.5,
            reviewCount = 319
        ),
        ProductDTO(
            productID = "clothing_7",
            name = "Denim Jacket",
            description = "The Denim Jacket is cut in the trucker silhouette that has remained unchanged in its essential proportions since it was first introduced decades ago, because the proportions simply work across body types and styling contexts. A medium wash gives it a lived-in look straight out of the box, and brass hardware at the pockets and front closure adds a quality detail that you notice up close. It layers over hoodies and sweaters in autumn and over shirts in spring, which makes it genuinely one of the most-reached-for pieces in a well-stocked wardrobe.",
            price = 89.00,
            images = listOf("#32D583", "#6366F1", "#FFB547"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 12,
            rating = 4.6,
            reviewCount = 208
        ),
        ProductDTO(
            productID = "clothing_8",
            name = "Hoodie Zip-Up",
            description = "The Hoodie Zip-Up is made from a heavyweight fleece that feels substantial and warm in a way that lighter hoodies never quite manage to replicate. A full-length YKK zipper runs smoothly under load and won't snag the fabric after repeated use, and a kangaroo pocket across the front provides both storage and a place to warm your hands. Ribbed cuffs and hem seal in warmth at the wrists and waist without feeling restrictive, and the relaxed fit works equally well as a layering piece or as a standalone top on cooler days.",
            price = 79.00,
            images = listOf("#FFB547", "#6366F1", "#32D583"),
            category = CategoryDTO(categoryID = "clothing", displayName = "Clothing", itemCount = 175),
            stockCount = 31,
            rating = 4.7,
            reviewCount = 462
        ),

        // --- ACCESSORIES ---
        ProductDTO(
            productID = "accessories_1",
            name = "Leather Belt",
            description = "The Leather Belt is cut from full-grain leather, which sits at the top of the leather quality hierarchy because it retains the natural grain of the hide and develops a patina over years of use rather than deteriorating the way corrected or bonded leather does. A solid brass buckle adds weight and presence to a piece that most people buy once and expect to last indefinitely, and the clean design works equally well with formal trousers and casual jeans. Available in black and tan in sizes from 28 to 44 inches.",
            price = 45.00,
            images = listOf("#6366F1", "#FFB547", "#E85A4F"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 24,
            rating = 4.6,
            reviewCount = 183
        ),
        ProductDTO(
            productID = "accessories_2",
            name = "Wool Scarf",
            description = "The Wool Scarf is woven from extra-fine merino wool in an oversized format that gives you enough fabric to wrap generously around your neck and still have length left to drape. A classic herringbone weave adds visual texture and structure to the fabric without making it stiff or scratchy, and the natural temperature-regulating properties of merino mean it keeps you warm in cold weather without overheating when you move indoors. The neutral colorway works across a wide range of outerwear so you don't have to think about whether it matches.",
            price = 55.00,
            images = listOf("#E85A4F", "#FFB547", "#6366F1"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 16,
            rating = 4.7,
            reviewCount = 97
        ),
        ProductDTO(
            productID = "accessories_3",
            name = "Sunglasses",
            description = "The Sunglasses combine polarized lenses with UV400 protection to reduce both glare from reflective surfaces and the full spectrum of ultraviolet radiation that causes long-term eye damage. Polarization makes a noticeable practical difference when you're driving, near water or in bright snow conditions, eliminating the horizontal glare that standard tinted lenses don't address. An acetate frame is lighter and more durable than plastic alternatives, and the lightweight construction means you can wear them for extended periods without them pressing uncomfortably on your nose or temples.",
            price = 85.00,
            images = listOf("#32D583", "#FFB547", "#6366F1"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 13,
            rating = 4.5,
            reviewCount = 214
        ),
        ProductDTO(
            productID = "accessories_4",
            name = "Beanie Hat",
            description = "The Beanie Hat is knitted from 100% merino wool in a fine-gauge rib that stretches comfortably over most head sizes while returning to its shape after each wear without bagging out over time. A slouchy fit sits naturally at the back of the head in a way that looks effortless rather than deliberate, and the merino fiber is soft enough to wear directly against the forehead without the irritation that scratchy wool causes. Available in ten colorways from neutral basics to seasonal accent colors that work within most wardrobes.",
            price = 32.00,
            images = listOf("#FFB547", "#32D583", "#6366F1"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 29,
            rating = 4.4,
            reviewCount = 156
        ),
        ProductDTO(
            productID = "accessories_5",
            name = "Card Holder",
            description = "The Card Holder is machined from aluminum to create a rigid shell that protects your cards from bending and breaking, and a built-in RFID-blocking layer prevents contactless scanning technology from reading your card data without your knowledge. A spring-loaded mechanism fans your cards out when you press the release, giving you immediate access to whichever card you need rather than having to pull each one out individually. The slim profile adds almost no bulk to your pocket compared to a traditional wallet, which makes a noticeable difference in everyday comfort.",
            price = 28.00,
            images = listOf("#6366F1", "#FFB547", "#32D583"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 38,
            rating = 4.6,
            reviewCount = 342
        ),
        ProductDTO(
            productID = "accessories_6",
            name = "Leather Gloves",
            description = "The Leather Gloves are cut from nappa leather, which is known for its exceptionally soft and supple hand feel compared to the stiffer leathers used in most entry-level gloves. A cashmere lining provides warmth without the bulk of thicker insulation, so the gloves remain slim enough to use a touchscreen or handle small objects without removing them. Touchscreen-compatible fingertips let you use your phone or tablet directly through the glove, which removes the main frustration of wearing gloves in cold weather.",
            price = 65.00,
            images = listOf("#E85A4F", "#FFB547", "#32D583"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 11,
            rating = 4.8,
            reviewCount = 74
        ),
        ProductDTO(
            productID = "accessories_7",
            name = "Silver Bracelet",
            description = "The Silver Bracelet is crafted from sterling silver with a chain construction that drapes naturally against the wrist and catches light with every movement. A lobster clasp fastens securely and releases cleanly with one hand, which makes it practical to put on and take off without assistance. The hypoallergenic silver alloy is suitable for sensitive skin, and a tarnish-resistant treatment slows the oxidation process that causes silver to darken over time, keeping the finish bright with minimal maintenance.",
            price = 49.00,
            images = listOf("#32D583", "#FFB547", "#E85A4F"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 17,
            rating = 4.5,
            reviewCount = 128
        ),
        ProductDTO(
            productID = "accessories_8",
            name = "Tie Clip",
            description = "The Tie Clip serves a practical function and an aesthetic one simultaneously, keeping your tie positioned correctly against your shirt while adding a polished metal detail to your overall look. Brushed stainless steel gives it a contemporary matte finish that works alongside both silver and gold tones in a watch, cufflinks or ring, and a gold accent along the edge adds just enough contrast to make it worth noticing up close. The clip mechanism holds securely on ties from 3.5cm to 7cm wide without stretching or marking the fabric.",
            price = 22.00,
            images =listOf("#FFB547", "#32D583", "#E85A4F"),
            category = CategoryDTO(categoryID = "accessories", displayName = "Accessories", itemCount = 112),
            stockCount = 21,
            rating = 4.3,
            reviewCount = 61
        )
    )
}