# -*- coding: utf-8 -*-
from odoo import api, fields, models, exceptions, _
from odoo.osv import osv
import re
from openerp.exceptions import Warning

class list_books(models.Model):
	_name = 'list.books'
	_description = 'List of Books'
	
	title = fields.Char(string='Title', required=True)
	author = fields.Char(string='Author', required=True)
	date_published = fields.Date(string='Date Published')
	page = fields.Integer(string="Number of Pages", default=False)
	types = fields.Selection([('novel', 'Novel'), ('documentation', 'Documentation'), ('other', 'Other')],string='Type of Book')
	
	@api.model
	def create(self,vals):
		if vals.get('page'):
			if not re.match("^[0-9]*$", vals['page']):
				raise osv.except_osv(_('Warning'), _('Number of Pages must be filled by number.'))
		res = super(list_books, self).create(vals)
		return res
	
	@api.multi
	def write(self,vals):
		for record in self:
			if vals.get('page'):
				if not re.match("^[0-9]*$", vals['page']):
					raise osv.except_osv(_('Warning'), _('Number of Pages must be filled by number.'))
			res = super(list_books, self).write(vals)
			return res
