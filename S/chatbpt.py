# import random
# import nltk
# from nltk.tokenize import word_tokenize

# # Define a dictionary of movies with genres
# movies = {
#     "action": ["The Dark Knight", "Inception", "Die Hard", "Mad Max: Fury Road", "The Avengers"],
#     "comedy": ["The Hangover", "Superbad", "Anchorman", "Dumb and Dumber", "Bridesmaids"],
#     "drama": ["The Shawshank Redemption", "Forrest Gump", "Schindler's List", "The Godfather", "Titanic"],
#     "horror": ["The Shining", "Get Out", "A Quiet Place", "Hereditary", "The Conjuring"],
#     "science fiction": ["Interstellar", "Blade Runner 2049", "The Matrix", "Avatar", "E.T. the Extra-Terrestrial"]
# }

# # Function to recommend a movie based on user input
# def recommend_movie_from_sentence(sentence):
#     tokens = word_tokenize(sentence.lower())
#     for token in tokens:
#         for genre, movie_list in movies.items():
#             if token in genre:
#                 return recommend_movie(genre)
#     return "Sorry, no movies found in the provided sentence."

# # Function to recommend a movie
# def recommend_movie(genre):
#     genre_movies = movies.get(genre.lower())
#     if genre_movies:
#         return random.choice(genre_movies)
#     else:
#         return "Sorry, no movies found for that genre."

# # Main function for the chatbot
# def movie_recommendation_chatbot():
#     print("Welcome to the Movie Recommendation Chatbot!")
#     print("I can recommend a movie based on the genre you provide or from a sentence.")

#     while True:
#         user_input = input("Enter a movie genre or a sentence: ").lower()

#         if user_input == 'exit' or user_input== 'no':
#             print("Goodbye!")
#             break

#         recommended_movie = recommend_movie_from_sentence(user_input)

#         print("Recommended movie:", recommended_movie)
#         print("Would you like to explore more movie genres or sentences? If so, feel free to enter another genre or sentence. Otherwise, type 'exit' to end the conversation.")

# # Run the chatbot
# if __name__ == "__main__":
#     nltk.download('punkt')
#     movie_recommendation_chatbot()




import nltk
from nltk.chat.util import Chat, reflections

pairs = [
    [
        r"Hi|Hello|Hey there|Hola",
        ["Hello, I'm your real estate assistant.\n"]
    ],
    [
        r"What's your expertise in real estate?",
        ["I specialize in real estate assistance worldwide. Where are you currently located or interested in exploring real estate?\n",]
    ],
    [
        r"What specific services do you offer in real estate?",
        [" I specialize in a range of real estate services, including property search, market analysis, and advice on buying, selling, or renting. Where are you currently located or interested in exploring real estate?\n",]
    ],
    [
        r"How is the real estate market",
        ['The real estate market in is dynamic. Are you looking to buy, sell, or rent a property in this area?\n',]
    ],
    [
        r"Any real estate suggestions around my workplace?",
        ["Property areas can vary. Are you looking for a specific size or type of property that suits your preferences?\n",]
    ],
    [
        r"What's the typical property area around here?",
        ["Great! In which area would you like to explore real estate options? I can help you find properties near your workplace.\n",]
    ],
    [
        r"I'm looking for properties in my area.",
        ["The property area can vary. Are you looking for a specific size or type of property? Let me know your preferences.\n",]
    ],
    [
        r"Can you recommend a real estate expert in my location?",
        ["While I'm here to assist, consulting a local real estate expert for specific advice is recommended. I can provide general information and insights.\n",]
    ],
    [
        r"Thank you for your help.",
        ["You're welcome! If you have more questions or need further assistance with real estate, feel free to ask.\n",]
    ],
    [
        r"quit|bye",
        ["Thank you for considering me as your real estate assistant. If you have more questions, feel free to ask!\n"]
    ],
]


print("---------------------------------------------")
print("Hello! I am RealtyBot, your real estate assistant at your service.\n")
print("You can start by saying 'hi' or 'hello'.")
print("To exit, simply say 'bye' or 'quit'.\n")
chat = Chat(pairs)
chat.converse()
