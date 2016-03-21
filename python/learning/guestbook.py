# coding: utf-8

import shelve

from flask import Flask, request, render_template, redirect, escape, Markup
from datetime import datetime

application = Flask(__name__)

DATA_FILE = 'guestbook.dat'

def save_data(name, comment, create_at):
    """Save Posted DATA
    """
    # open database file by using shelve module
    database = shelve.open(DATA_FILE)
    # create a new list if database does not have greeting_list
    if 'greeting_list' not in database:
        greeting_list = []
    else:
        # retrieve data from database
        greeting_list = database['greeting_list']
    # add data to top of list
    greeting_list.insert(0, {
        'name': name,
        'comment': comment,
        'create_at': create_at
    })
    # update database
    database['greeting_list'] = greeting_list
    # close database
    database.close()

def load_data():
    """return posted data
    """
    # open database file by using shelve module
    database = shelve.open(DATA_FILE)
    # return greeting_list. return empty list if there is no data.
    greeting_list = database.get('greeting_list', [])
    database.close()
    return greeting_list

@application.route('/')
def index():
    """ Top Page
    display a page with templates
    """
    # load post data
    greeting_list = load_data()
    return render_template('index.html',greeting_list=greeting_list)

@application.route('/post', methods=['POST'])
def post():
    """ URL for post
    """
    # retrieve data from post
    name = request.form.get('name') # name
    comment = request.form.get('comment') # comment
    create_at = datetime.now() # post date
    # save data
    save_data(name, comment, create_at)
    # redirect to top page after save data
    return redirect('/')

if __name__ == '__main__':
    # execute application with IP 127.0.0.1 and port 8000
    application.run('127.0.0.1', 8000, debug=True)
