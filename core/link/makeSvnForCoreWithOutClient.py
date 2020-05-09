#!/usr/bin/env python 
# -*- coding: utf-8 -*-

from __future__ import print_function
import os

tempPath = os.getcwd() + '/temp.txt'
separator = '\n'

def svn(cmd):
	os.system('svn ' + cmd)

def add(cmd):
	svn('add ' + cmd)

def ignore(dic, dir):
	cmd = 'propset svn:ignore -F "'
	tf = open(tempPath, 'w')
	for key in dic:
		#print(key, file=tf)
		tf.write(key + separator)

	tf.close()
	cmd += tempPath + '" "' + dir + '"'
	svn(cmd)

def externals(dic, dir, path):
	cmd = 'propset svn:externals -F "'
	tf = open(tempPath, 'w')
	for key in dic:
		#print(path + key, file=tf)
		tf.write(path + key + separator)

	tf.close()
	cmd += tempPath + '" "' + dir + '"'
	svn(cmd)


if __name__ == '__main__':
	localPath = os.getcwd()
	comment = 'first'
	
	os.chdir(os.path.dirname(os.getcwd()))
	os.chdir(os.path.dirname(os.getcwd()))

	if os.path.exists(tempPath):
		os.remove(tempPath)
	
	svn('propset svn:global-ignores -F "' + localPath + '/svnProps/core_ignore.txt" "."')
	
	add('core --depth empty')
	add('core/common')
	
	add('core/link')
	pycache = localPath + '/__pycache__'
	if not os.path.exists(pycache):
		os.makedirs(pycache)
	ignore(['__pycache__'], 'core/link')
	
	add('core/docs')
	ignore(['工作计划', '文献'], 'core/docs')
	
	add('core/server --depth empty')
	
	ignore(['toolProject', 'testProject'], 'core/server')
	
	add('core/server/project')
	add('core/server/clientProject')
	add('core/server/gmClientProject')
	
	#rem tools
	add('core/server/tools --depth files')
	ignore(['preJar'], 'core/server/tools')
	add('core/server/tools/ant')
	add('core/server/tools/jar')

	ignore(['codeHistory','client','clientLaya'], 'core')
	#rem client

	svn('commit --depth infinity -m ' + comment)
	
	os.remove(tempPath)
	os.system("pause")
